package sudoku.strategy.impl.strategy.grid.impl;

import sudoku.Cell;
import sudoku.Zone;
import sudoku.Grid;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.CellStrategy;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class SquareStrategyByCell implements CellStrategy {

    @Override
    public Optional<SolutionStep> findSolutionStepFor(Grid grid, Integer rowIndex, Integer columnIndex) {
        if (grid.getCells().get(rowIndex).get(columnIndex).getValue().isPresent())
            return Optional.empty();

        Zone square = grid.squareBy(rowIndex, columnIndex);
        List<Cell> emptyCells = square.cells
                                      .stream()
                                      .filter(c -> c.getValue().isEmpty())
                                      .collect(Collectors.toList());

        List<Grid.PossibleValues> possibleValuesByCell = emptyCells.stream()
                                                                   .map(grid::getPossibleValuesFor)
                                                                   .collect(Collectors.toList());

        List<Grid.PossibleValues> possibleValuesWithoutInterestedCell = possibleValuesByCell.stream()
                                                                                            .filter(pv -> pv.getCell().getRowIndex() != rowIndex || pv.getCell().getColumnIndex() != columnIndex)
                                                                                            .collect(Collectors.toList());

        Set<Integer> singleCellPossibleValues = possibleValuesByCell.stream()
                                                                    .filter(pv -> pv.getCell().getRowIndex() == rowIndex && pv.getCell().getColumnIndex() == columnIndex)
                                                                    .findFirst()
                                                                    .get()
                                                                    .getPossibleValues();

        return singleCellPossibleValues.stream()
                                       .filter(v -> possibleValuesWithoutInterestedCell.stream().noneMatch(possibleValues -> possibleValues.getPossibleValues().contains(v)))
                                       .findFirst()
                                       .map(value -> new SolutionStep(rowIndex, columnIndex, value));
    }
}
