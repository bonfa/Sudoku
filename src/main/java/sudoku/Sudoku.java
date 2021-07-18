package sudoku;

import sudoku.models.Grid;

import java.util.function.UnaryOperator;

import static sudoku.impl.SolutionStepApplier.solutionStepApplier;
import static sudoku.impl.strategy.SolutionStrategy.getFirstSolutionStep;

public class Sudoku {
    public static final UnaryOperator<Grid> sudoku =
            (Grid grid) -> getFirstSolutionStep.apply(grid)
                                               .map(solutionStep -> solutionStepApplier.apply(grid, solutionStep))
                                               .orElse(grid); //TODO for the moment, if no strategy can be applied, the same input grid is returned. Evaluate if it is necessary to change this behavior in the future
}
