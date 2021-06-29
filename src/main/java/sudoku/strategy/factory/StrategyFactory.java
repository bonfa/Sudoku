package sudoku.strategy.factory;

import sudoku.strategy.impl.StepByStepGridStrategy;
import sudoku.strategy.impl.strategy.impl.ByPossibleValues2;
import sudoku.strategy.impl.strategy.impl.SquareStrategyByCell;

import java.util.ArrayList;
import java.util.List;

public class StrategyFactory {
    public List<StepByStepGridStrategy> createStrategiesFor() { //TODO test
        List<StepByStepGridStrategy> strategies = new ArrayList<>();

        strategies.add(new StepByStepGridStrategy(new ByPossibleValues2()));
        strategies.add(new StepByStepGridStrategy(new SquareStrategyByCell()));

        return strategies;
    }
}
