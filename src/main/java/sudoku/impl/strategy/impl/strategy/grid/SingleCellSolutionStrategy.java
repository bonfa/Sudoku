package sudoku.impl.strategy.impl.strategy.grid;

import sudoku.impl.extractors.GridExtractors;
import sudoku.impl.models.Grid;
import sudoku.impl.models.Position;
import sudoku.impl.strategy.impl.SolutionStep;
import sudoku.impl.strategy.impl.strategy.CellStrategy;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SingleCellSolutionStrategy implements Function<Grid, Optional<SolutionStep>> {

    private final CellStrategy cellStrategy;

    public SingleCellSolutionStrategy(CellStrategy cellStrategy) {
        this.cellStrategy = cellStrategy;
    }

    @Override
    public Optional<SolutionStep> apply(Grid grid) {
        Integer dimension = GridExtractors.sizeExtractor.apply(grid);

        return IntStream.range(0, dimension).boxed()
                        .flatMap(rowIndex -> IntStream.range(0, dimension).boxed()
                                                      .flatMap(columnIndex -> cellStrategy.findSolutionStepFor(grid, new Position(rowIndex, columnIndex)).stream()))
                        .findFirst();
    }
}
