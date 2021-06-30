package sudoku.strategy.factory;

import sudoku.Grid;
import sudoku.strategy.factory.grid.GridStrategyFactory;
import sudoku.strategy.factory.zone.ZoneStrategyFactory;
import sudoku.strategy.impl.SolutionStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class StrategyFactory {
    private final ZoneStrategyFactory zoneStrategyFactory = new ZoneStrategyFactory();
    private final GridStrategyFactory gridStrategyFactory = new GridStrategyFactory();

    public List<Function<Grid, Optional<SolutionStep>>> createStrategies() { //TODO test
        List<Function<Grid, Optional<SolutionStep>>> strategies = new ArrayList<>();

        strategies.addAll(zoneStrategyFactory.createStrategies());
        strategies.addAll(gridStrategyFactory.createStrategies());

        return strategies;
    }
}
