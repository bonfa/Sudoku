package sudoku.impl.strategy.factory;

import sudoku.impl.models.Grid;
import sudoku.impl.models.SolutionStep;
import sudoku.impl.strategy.impl.CandidatesFinder;
import sudoku.impl.strategy.SingleCellSolutionStrategy;
import sudoku.impl.strategy.impl.CellWithSingleCandidate;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class StrategyFactory {
    public List<Function<Grid, Optional<SolutionStep>>> createStrategies() {
        return List.of(new SingleCellSolutionStrategy(new CellWithSingleCandidate(new CandidatesFinder())));
    }
}
