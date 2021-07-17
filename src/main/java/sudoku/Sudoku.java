package sudoku;

import sudoku.models.Grid;
import sudoku.models.SolutionStep;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Sudoku implements UnaryOperator<Grid> {
    private final Function<Grid, Optional<SolutionStep>> solutionStepFinder;
    private final BiFunction<Grid, SolutionStep, Grid> solutionStepApplier;

    public Sudoku(Function<Grid, Optional<SolutionStep>> solutionStepFinder,
                  BiFunction<Grid, SolutionStep, Grid> solutionStepApplier) {
        this.solutionStepFinder = solutionStepFinder;
        this.solutionStepApplier = solutionStepApplier;
    }

    public Grid apply(Grid grid) {
        return solutionStepFinder.apply(grid)
                                 .map(s -> solutionStepApplier.apply(grid, s))
                                 .orElse(grid); //TODO for the moment, if no strategy can be applied, the same input grid is returned. Evaluate if it is necessary to change this behavior in the future
    }
}
