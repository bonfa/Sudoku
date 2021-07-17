package sudoku.impl.strategy.factory;

import sudoku.models.Grid;
import sudoku.models.SolutionStep;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static sudoku.impl.strategy.SolutionStrategy.getFirstSolutionStep;

public class StrategyFactory {
    public List<Function<Grid, Optional<SolutionStep>>> createStrategies() {
        return List.of(getFirstSolutionStep);
    }
}
