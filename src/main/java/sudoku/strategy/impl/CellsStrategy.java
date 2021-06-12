package sudoku.strategy.impl;

import sudoku.Cells;
import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

import java.util.List;

public abstract class CellsStrategy implements SolutionStrategy {
    //todo this class (and its test) is a bit duplicated with Row class. check if this can be improved

    @Override
    public boolean canAddOneNumber(Grid grid) {
        return getCells(grid).stream().anyMatch(Cells::canAddOneNumber);
    }

    @Override
    public Grid addOneNumber(Grid grid) {
        getCells(grid).stream().filter(Cells::canAddOneNumber).findFirst().ifPresent(Cells::addOneNumber);
        return grid;
    }

    protected abstract List<Cells> getCells(Grid grid);
}
