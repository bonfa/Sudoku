package sudoku.strategy.impl.strategy;

import sudoku.Grid;
import sudoku.strategy.impl.SolutionStep;

import java.util.Optional;

public interface CellStrategy {
    Optional<SolutionStep> findSolutionStepFor(Grid grid, Integer rowIndex, Integer columnIndex);
}
