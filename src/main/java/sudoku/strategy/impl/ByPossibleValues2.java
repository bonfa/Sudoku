package sudoku.strategy.impl;

import sudoku.Grid;

import java.util.Optional;
import java.util.Set;

public class ByPossibleValues2 {
    public Optional<SolutionStep> findSolutionStepFor(Grid grid, Integer rowIndex, Integer columnIndex) {
        Set<Integer> possibleValues = grid.getPossibleValuesFor(grid.getCells().get(rowIndex).get(columnIndex)).getPossibleValues();

        if (possibleValues.size() == 1)
            return possibleValues.stream().findFirst().map(value -> new SolutionStep(rowIndex, columnIndex, value));

        return Optional.empty();
    }

    //TODO use something else - rename it or change it
    public static class SolutionStep {
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
