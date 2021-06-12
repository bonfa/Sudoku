package sudoku.strategy.impl;

import sudoku.Cell;
import sudoku.Cells;
import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static sudoku.Cells.difference;

public class SingleCellStrategy implements SolutionStrategy {
    private final Integer rowIndex;
    private final Integer columnIndex;

    public SingleCellStrategy(Integer rowIndex, Integer columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    @Override
    public boolean canAddOneNumber(Grid grid) {
        Set<Integer> freeValues = getFreeValuesForCell(grid);

        return freeValues.size() == 1;
    }

    @Override
    public Grid addOneNumber(Grid grid) {
        Set<Integer> freeValues = getFreeValuesForCell(grid);

        grid.getRows().get(rowIndex).getCells().get(columnIndex).setValue(freeValues.stream().findFirst().get());

        return grid;
    }

    private Set<Integer> getFreeValuesForCell(Grid grid) {
        Predicate<Cell> sameCoordinates = cell -> cell.getRowIndex() == rowIndex && cell.getColumnIndex() == columnIndex;

        Set<Integer> allPossibleValues = grid.allPossibleValues();
        Set<Integer> valuesAlreadyPresentInRow = grid.getRows().get(rowIndex).valuesAlreadyPresent();
        Set<Integer> valuesAlreadyPresentInColumns = grid.getColumns().get(columnIndex).valuesAlreadyPresent();

        Set<Integer> valuesAlreadyPresentInSquares = grid.getSquares() //TODO get(rowIndex, columnIndex)
                                                         .stream()
                                                         .filter(r -> r.getCells().stream().anyMatch(sameCoordinates))
                                                         .findFirst()
                                                         .get()
                                                         .valuesAlreadyPresent();

        return difference(allPossibleValues,
                          sum(valuesAlreadyPresentInRow,
                              valuesAlreadyPresentInColumns,
                              valuesAlreadyPresentInSquares));
    }

    private static Set<Integer> sum(Set<Integer>... sets)
    {
        Set<Integer> addition = new HashSet<>();
        Arrays.stream(sets).forEach(addition::addAll);
        return addition;
    }
}
