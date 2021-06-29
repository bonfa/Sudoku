package sudoku.strategy.impl;

import sudoku.Cell;
import sudoku.Cells;
import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static sudoku.Grid.*;

public class SquareStrategy implements SolutionStrategy {
    private final Integer rowIndex;
    private final Integer columnIndex;

    public SquareStrategy(Integer rowIndex, Integer columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    @Override
    public boolean canAddOneNumber(Grid grid) {
        return getFreeValuesForCell(grid).isPresent();
    }

    @Override
    public Grid addOneNumber(Grid grid) {
        Optional<Integer> theSinglePossibleValue = getFreeValuesForCell(grid);
        grid.getCells().get(rowIndex).get(columnIndex).setValue(theSinglePossibleValue.get());
        return grid;
    }

    private Optional<Integer> getFreeValuesForCell(Grid grid) {
        if (grid.getCells().get(rowIndex).get(columnIndex).getValue().isPresent())
            return Optional.empty();

        Cells square = grid.squareBy(rowIndex, columnIndex);
        List<Cell> emptyCells = square.getCells()
                                      .stream()
                                      .filter(c -> c.getValue().isEmpty())
                                      .collect(Collectors.toList());

        List<PossibleValues> possibleValuesByCell = emptyCells.stream()
                                                              .map(grid::getPossibleValuesFor)
                                                              .collect(Collectors.toList());

        List<PossibleValues> possibleValuesWithoutInterestedCell = possibleValuesByCell.stream()
                                                                                       .filter(pv -> pv.getCell().getRowIndex() != rowIndex || pv.getCell().getColumnIndex() != columnIndex)
                                                                                       .collect(Collectors.toList());

        Set<Integer> singleCellPossibleValues = possibleValuesByCell.stream()
                                                                    .filter(pv -> pv.getCell().getRowIndex() == rowIndex && pv.getCell().getColumnIndex() == columnIndex)
                                                                    .findFirst()
                                                                    .get()
                                                                    .getPossibleValues();

        return singleCellPossibleValues.stream()
                                       .filter(v -> possibleValuesWithoutInterestedCell.stream().noneMatch(possibleValues -> possibleValues.getPossibleValues().contains(v)))
                                       .findFirst();
    }
}
