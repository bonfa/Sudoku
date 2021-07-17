package sudoku;

import sudoku.models.Grid;
import sudoku.models.SolutionStep;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import static sudoku.impl.strategy.SolutionStrategy.getFirstSolutionStep;

public class Sudoku implements UnaryOperator<Grid> {
    private final BiFunction<Grid, SolutionStep, Grid> solutionStepApplier;

    public Sudoku(BiFunction<Grid, SolutionStep, Grid> solutionStepApplier) {
        this.solutionStepApplier = solutionStepApplier;
    }

    public Grid apply(Grid grid) {
        return getFirstSolutionStep.apply(grid)
                                   .map(s -> solutionStepApplier.apply(grid, s))
                                   .orElse(grid); //TODO for the moment, if no strategy can be applied, the same input grid is returned. Evaluate if it is necessary to change this behavior in the future
    }
}
