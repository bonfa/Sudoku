package sudoku.impl;

import sudoku.models.Grid;
import sudoku.models.SolutionStep;

import java.util.function.BiFunction;

import static sudoku.impl.extractors.GridOperators.updateGrid;

public class SolutionStepApplier {
    public static final BiFunction<Grid, SolutionStep, Grid> solutionStepApplier =
            (Grid grid, SolutionStep solutionStep) -> updateGrid.apply(grid).apply(solutionStep);
}
