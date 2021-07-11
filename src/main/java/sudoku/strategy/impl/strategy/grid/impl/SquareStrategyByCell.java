package sudoku.strategy.impl.strategy.grid.impl;

import sudoku.Cell;
import sudoku.Grid;
import sudoku.Zone;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.CellStrategy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

import sudoku.Numbers;

public class SquareStrategyByCell implements CellStrategy {

    private final Predicate<Cell> isEmpty = c -> c.getValue().isEmpty();
    private final BiPredicate<Grid.Position, Grid.Position> samePosition = (p1, p2) -> p1.getRowIndex() == p2.getRowIndex() && p1.getColumnIndex() == p2.getColumnIndex();

    @Override
    public Optional<SolutionStep> findSolutionStepFor(Grid grid, Integer rowIndex, Integer columnIndex) {
        final Grid.Position position = new Grid.Position(rowIndex, columnIndex);

        if (grid.cellAt(position).getValue().isPresent())
            return Optional.empty();

        Zone square = grid.squareBy(position);

        Map<Boolean, List<Tuple>> candidatesBySamePosition = square.cells.stream()
                                                                         .filter(isEmpty)
                                                                         .map(cell -> new Tuple(cell.getPosition(), grid.getCandidates(cell)))
                                                                         .collect(partitioningBy(pippo -> samePosition.test(pippo.position, position)));

        List<Numbers> candidatesWithoutInterestedCell = candidatesBySamePosition.get(false).stream().map(p -> p.candidates).collect(Collectors.toList());
        Set<Integer> singleCellCandidates = candidatesBySamePosition.get(true).stream().findFirst().map(p -> p.candidates).get().getValues();

        return singleCellCandidates.stream()
                                   .filter(v -> candidatesWithoutInterestedCell.stream().noneMatch(candidates -> candidates.getValues().contains(v)))
                                   .findFirst()
                                   .map(value -> new SolutionStep(new Grid.Position(rowIndex, columnIndex), value));
    }

    private static final class Tuple {
        private final Grid.Position position;
        private final Numbers candidates;

        public Tuple(Grid.Position position, Numbers candidates) {
            this.position = position;
            this.candidates = candidates;
        }
    }
}
