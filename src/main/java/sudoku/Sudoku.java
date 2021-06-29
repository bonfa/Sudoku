package sudoku;

import sudoku.strategy.impl.SolutionStep;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Sudoku implements UnaryOperator<Grid> {
    private final List<Function<Grid, Optional<SolutionStep>>> strategies;
    private final BiFunction<Grid, SolutionStep, Grid> solutionStepApplier;

    public Sudoku(List<Function<Grid, Optional<SolutionStep>>> strategies, BiFunction<Grid, SolutionStep, Grid> solutionStepApplier) {
        this.strategies = strategies;
        this.solutionStepApplier = solutionStepApplier;
    }

    public Grid apply(Grid grid) {
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
