package sudoku.strategy.impl;

import sudoku.Cells;
import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

import java.util.List;

public class RowStrategy extends CellsStrategy {
    @Override
    protected List<Cells> getCells(Grid grid) {
        return grid.getRows();
    }
}
