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
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static sudoku.Grid.Candidates;

public class SquareStrategyByCell implements CellStrategy {

    private final Predicate<Cell> isEmpty = c -> c.getValue().isEmpty();

    @Override
    public Optional<SolutionStep> findSolutionStepFor(Grid grid, Integer rowIndex, Integer columnIndex) {
        if (grid.getCells().get(rowIndex).get(columnIndex).getValue().isPresent())
            return Optional.empty();

        Zone square = grid.squareBy(rowIndex, columnIndex);

        Map<Boolean, List<Candidates>> candidatesBySamePosition = square.cells.stream()
                                                                              .filter(isEmpty)
                                                                              .map(grid::getCandidates)
                                                                              .collect(partitioningBy(candidate -> candidate.getRowIndex().equals(rowIndex) && candidate.getColumnIndex().equals(columnIndex)));
        List<Candidates> candidatesWithoutInterestedCell = candidatesBySamePosition.get(false);
        Set<Integer> singleCellCandidates = candidatesBySamePosition.get(true).stream().findFirst().get().getCandidates();

        return singleCellCandidates.stream()
                                   .filter(v -> candidatesWithoutInterestedCell.stream().noneMatch(candidates -> candidates.getCandidates().contains(v)))
                                   .findFirst()
                                   .map(value -> new SolutionStep(rowIndex, columnIndex, value));
    }
}
