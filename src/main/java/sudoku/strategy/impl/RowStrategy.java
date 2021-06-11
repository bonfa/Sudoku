package sudoku.strategy.impl;

import sudoku.Cells;
import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

public class RowStrategy implements SolutionStrategy {
    //todo this class (and its test) is a bit duplicated with tow class. check if this can be improved

    @Override
    public boolean canAddOneNumber(Grid grid) {
        return grid.getRows().stream().anyMatch(Cells::canAddOneNumber);
    }

    @Override
    public Grid addOneNumber(Grid grid) {
        grid.getRows().stream().filter(Cells::canAddOneNumber).findFirst().ifPresent(Cells::addOneNumber);
        return grid;
    }
}
