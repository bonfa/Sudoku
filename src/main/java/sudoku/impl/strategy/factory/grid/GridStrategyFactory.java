package sudoku.impl.strategy.factory.grid;

import sudoku.impl.strategy.CandidatesFinder;
import sudoku.impl.models.Grid;
import sudoku.impl.strategy.impl.SolutionStep;
import sudoku.impl.strategy.impl.strategy.grid.SingleCellSolutionStrategy;
import sudoku.impl.strategy.impl.strategy.grid.impl.CellWithSingleCandidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class GridStrategyFactory {
    public List<Function<Grid, Optional<SolutionStep>>> createStrategies() {
        List<Function<Grid, Optional<SolutionStep>>> strategies = new ArrayList<>();

        strategies.add(new SingleCellSolutionStrategy(new CellWithSingleCandidate(new CandidatesFinder())));
//        strategies.add(new SingleCellSolutionStrategy(new SquareStrategyByCell()));

        return strategies;
    }
}
