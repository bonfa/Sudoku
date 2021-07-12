package sudoku;

import sudoku.models.Grid;
import sudoku.strategy.impl.SolutionStep;

import java.util.function.BiFunction;

import static sudoku.GridExtractors.*;

public class SolutionStepApplier implements BiFunction<Grid, SolutionStep, Grid> {
    @Override
    public Grid apply(Grid grid, SolutionStep solutionStep) {
        cellExtractor.apply(grid, solutionStep.position).setValue(solutionStep.value);

        return grid;
    }
}
