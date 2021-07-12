package sudoku.impl;

import sudoku.impl.models.Grid;
import sudoku.impl.models.SolutionStep;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SolutionStepFinder implements Function<Grid, Optional<SolutionStep>> {

    private final List<Function<Grid, Optional<SolutionStep>>> strategies;

    public SolutionStepFinder(List<Function<Grid, Optional<SolutionStep>>> strategies) {
        this.strategies = strategies;
    }

    public Optional<SolutionStep> apply(Grid grid) {
        return strategies.stream()
                         .map(s -> s.apply(grid))
                         .flatMap(Optional::stream)
                         .findFirst();
    }
}
