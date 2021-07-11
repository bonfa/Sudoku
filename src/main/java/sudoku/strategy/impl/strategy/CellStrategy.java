package sudoku.strategy.impl.strategy;

import sudoku.models.Grid;
import sudoku.models.Position;
import sudoku.strategy.impl.SolutionStep;

import java.util.Optional;

public interface CellStrategy {
    Optional<SolutionStep> findSolutionStepFor(Grid grid, Position position);
}
