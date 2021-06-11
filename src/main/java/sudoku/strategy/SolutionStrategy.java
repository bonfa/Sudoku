package sudoku.strategy;

import sudoku.Grid;

public interface SolutionStrategy {
    boolean canAddOneNumber(Grid grid);
    Grid addOneNumber(Grid grid);
}
