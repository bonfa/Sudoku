package sudoku.strategy.impl.strategy;

import sudoku.Grid;

import java.util.Optional;

public interface CellStrategy {
    Optional<SolutionStep> findSolutionStepFor(Grid grid, Integer rowIndex, Integer columnIndex);

    //TODO improve this one
    class SolutionStep {
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
