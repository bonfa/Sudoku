package sudoku.strategy.impl;

import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

import java.util.Optional;
import java.util.stream.IntStream;

public class ByPossibleValues implements SolutionStrategy {

    private final ByPossibleValues2 byPossibleValues2;

    public ByPossibleValues(ByPossibleValues2 byPossibleValues2) {
        this.byPossibleValues2 = byPossibleValues2;
    }

    @Override
    public boolean canAddOneNumber(Grid grid) {
        return findSolutionStepFor(grid).isPresent();
    }

    @Override
    public Grid addOneNumber(Grid grid) {
        ByPossibleValues2.SolutionStep solutionStep = findSolutionStepFor(grid).get();

        grid.getRows().get(solutionStep.rowIndex).getCells().get(solutionStep.columnIndex).setValue(solutionStep.value);

        return grid;
    }

    private Optional<ByPossibleValues2.SolutionStep> findSolutionStepFor(Grid grid) {
        Grid.Dimensions dimensions = grid.getDimensions();

        return IntStream.range(0, dimensions.rows).boxed()
                        .flatMap(rowIndex -> IntStream.range(0, dimensions.columns).boxed()
                                                      .flatMap(columnIndex -> byPossibleValues2.findSolutionStepFor(grid, rowIndex, columnIndex).stream()))
                        .findFirst();
    }

}
