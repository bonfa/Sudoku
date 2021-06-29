package sudoku;

import sudoku.strategy.impl.SolutionStep;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Sudoku {
    private final List<Function<Grid, Optional<SolutionStep>>> strategies;
    private final SolutionStepApplier solutionStepApplier;

    public Sudoku(List<Function<Grid, Optional<SolutionStep>>> strategies, SolutionStepApplier solutionStepApplier) {
        this.strategies = strategies;
        this.solutionStepApplier = solutionStepApplier;
    }

    public Grid addOneNumber(Grid grid) {
        return strategies.stream()
                         .map(s -> s.apply(grid))
                         .flatMap(Optional::stream)
                         .findFirst()
                         .map(s -> solutionStepApplier.apply(grid, s))
                         .orElse(grid); //TODO for the moment, if no strategy can be applied, the same input grid is returned. Evaluate if it is necessary to change this behavior in the future
    }

    public static class SolutionStepApplier implements BiFunction<Grid, SolutionStep, Grid> {
        @Override
        public Grid apply(Grid grid, SolutionStep solutionStep) {
            grid.getCells().get(solutionStep.rowIndex).get(solutionStep.columnIndex).setValue(solutionStep.value);
            return grid;
        }
    }
}
