package sudoku.impl;

import sudoku.impl.models.Grid;
import sudoku.impl.strategy.impl.SolutionStep;

import java.util.function.BiFunction;

import static sudoku.impl.extractors.GridExtractors.*;

public class SolutionStepApplier implements BiFunction<Grid, SolutionStep, Grid> {
    @Override
    public Grid apply(Grid grid, SolutionStep solutionStep) {
        cellExtractor.apply(grid, solutionStep.position).setValue(solutionStep.value);

        return grid;
    }
}
