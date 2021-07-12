package sudoku.impl.strategy.factory;

import sudoku.impl.models.Grid;
import sudoku.impl.strategy.factory.grid.GridStrategyFactory;
import sudoku.impl.strategy.impl.SolutionStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class StrategyFactory {
    private final GridStrategyFactory gridStrategyFactory = new GridStrategyFactory();

    public List<Function<Grid, Optional<SolutionStep>>> createStrategies() {
        List<Function<Grid, Optional<SolutionStep>>> strategies = new ArrayList<>();

        strategies.addAll(gridStrategyFactory.createStrategies());

        return strategies;
    }
}
