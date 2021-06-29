package sudoku.strategy.impl;

import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

public class SingleCellStrategy implements SolutionStrategy { //TODO rename
    @Override
    public boolean canAddOneNumber(Grid grid) {
        return findSolutionStepFor(grid).isPresent();
    }

    @Override
    public Grid addOneNumber(Grid grid) {
        SolutionStep solutionStep = findSolutionStepFor(grid).get();

        grid.getRows().get(solutionStep.rowIndex).getCells().get(solutionStep.columnIndex).setValue(solutionStep.value);

        return grid;
    }

    private Optional<SolutionStep> findSolutionStepFor(Grid grid) {
        Grid.Dimensions dimensions = grid.getDimensions();

        return IntStream.range(0, dimensions.rows).boxed()
                        .flatMap(rowIndex -> IntStream.range(0, dimensions.columns).boxed()
                                                      .flatMap(columnIndex -> getCellWithValue(grid, rowIndex, columnIndex).stream()))
                        .findFirst();
    }

    private Optional<SolutionStep> getCellWithValue(Grid grid, Integer rowIndex, Integer columnIndex) {
        Set<Integer> possibleValues = grid.getPossibleValuesFor(grid.getCells().get(rowIndex).get(columnIndex)).getPossibleValues();

        if (possibleValues.size() == 1)
            return possibleValues.stream().findFirst().map(value -> new SolutionStep(rowIndex, columnIndex, value));

        return Optional.empty();
    }

    private static class SolutionStep {
        public final Integer rowIndex;
        public final Integer columnIndex;
        public final Integer value;

        public SolutionStep(Integer rowIndex, Integer columnIndex, Integer value) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
            this.value = value;
        }
    }
}
