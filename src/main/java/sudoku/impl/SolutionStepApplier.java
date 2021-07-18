package sudoku.impl;

import sudoku.models.Grid;
import sudoku.models.SolutionStep;

import java.util.function.BiFunction;

import static sudoku.impl.extractors.GridExtractors.*;

public class SolutionStepApplier {
    //FIXME remove the side effect
    public static final BiFunction<Grid, SolutionStep, Grid> solutionStepApplier =
            (Grid grid, SolutionStep solutionStep) -> {
                cellExtractor.apply(grid, solutionStep.position).setValue(solutionStep.value);

                return grid;
            };
}
