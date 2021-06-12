package sudoku.strategy.impl;

import sudoku.Cells;
import sudoku.Grid;

import java.util.List;

public class SquareStrategy extends CellsStrategy {
    @Override
    protected List<Cells> getCells(Grid grid) {
        return grid.getSquares();
    }
}
