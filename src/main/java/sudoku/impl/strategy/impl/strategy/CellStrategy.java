package sudoku.impl.strategy.impl.strategy;

import sudoku.impl.models.Grid;
import sudoku.impl.models.Position;
import sudoku.impl.strategy.impl.SolutionStep;

import java.util.Optional;

public interface CellStrategy {
    Optional<SolutionStep> findSolutionStepFor(Grid grid, Position position);
}
