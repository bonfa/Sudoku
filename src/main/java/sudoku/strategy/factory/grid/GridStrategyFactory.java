package sudoku.strategy.factory.grid;

import sudoku.CandidatesFinder;
import sudoku.models.Grid;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.grid.SingleCellSolutionStrategy;
import sudoku.strategy.impl.strategy.grid.impl.CellWithSingleCandidate;

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
