package sudoku.strategy.impl.strategy.grid;

import sudoku.Grid;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.CellStrategy;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

import static sudoku.Grid.Dimensions;

public class SingleCellSolutionStrategy implements Function<Grid, Optional<SolutionStep>> {

    private final CellStrategy cellStrategy;

    public SingleCellSolutionStrategy(CellStrategy cellStrategy) {
        this.cellStrategy = cellStrategy;
    }

    @Override
    public Optional<SolutionStep> apply(Grid grid) {
        Dimensions dimensions = grid.getDimensions();

        return IntStream.range(0, dimensions.rows).boxed()
                        .flatMap(rowIndex -> IntStream.range(0, dimensions.columns).boxed()
                                                      .flatMap(columnIndex -> cellStrategy.findSolutionStepFor(grid, rowIndex, columnIndex).stream()))
                        .findFirst();
    }
}
