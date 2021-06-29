package sudoku.strategy.factory;

import sudoku.Grid;
import sudoku.strategy.factory.grid.GridStrategyFactory;
import sudoku.strategy.factory.sector.SectorStrategyFactory;
import sudoku.strategy.impl.SolutionStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class StrategyFactory {
    private final SectorStrategyFactory sectorStrategyFactory = new SectorStrategyFactory();
    private final GridStrategyFactory gridStrategyFactory = new GridStrategyFactory();

    public List<Function<Grid, Optional<SolutionStep>>> createStrategies() { //TODO test
        List<Function<Grid, Optional<SolutionStep>>> strategies = new ArrayList<>();

        strategies.addAll(sectorStrategyFactory.createStrategies());
        strategies.addAll(gridStrategyFactory.createStrategies());

        return strategies;
    }
}
