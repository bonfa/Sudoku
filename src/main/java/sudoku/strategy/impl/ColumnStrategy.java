package sudoku.strategy.impl;

import sudoku.Cells;
import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

import java.util.List;

public class ColumnStrategy extends CellsStrategy {
    @Override
    protected List<Cells> getCells(Grid grid) {
        return grid.getColumns();
    }
}
