package sudoku.strategy.impl;

import sudoku.Grid;
import sudoku.strategy.impl.strategy.CellStrategy;
import sudoku.strategy.impl.strategy.CellStrategy.SolutionStep;

import java.util.Optional;
import java.util.stream.IntStream;

import static sudoku.Grid.*;

public class StepByStepGridStrategy {

    private final CellStrategy cellStrategy;

    public StepByStepGridStrategy(CellStrategy cellStrategy) {
        this.cellStrategy = cellStrategy;
    }

    public boolean canAddOneNumber(Grid grid) {
        return findSolutionStepFor(grid).isPresent();
    }

    public Grid addOneNumber(Grid grid) {
        SolutionStep solutionStep = findSolutionStepFor(grid).get();

        grid.getCells().get(solutionStep.rowIndex).get(solutionStep.columnIndex).setValue(solutionStep.value);

        return grid;
    }

    private Optional<SolutionStep> findSolutionStepFor(Grid grid) {
        Dimensions dimensions = grid.getDimensions();

        return IntStream.range(0, dimensions.rows).boxed()
                        .flatMap(rowIndex -> IntStream.range(0, dimensions.columns).boxed()
                                                      .flatMap(columnIndex -> cellStrategy.findSolutionStepFor(grid, rowIndex, columnIndex).stream()))
                        .findFirst();
    }
}
