package sudoku.impl.strategy;

import sudoku.impl.extractors.GridExtractors;
import sudoku.impl.models.Grid;
import sudoku.impl.models.Position;
import sudoku.impl.models.SolutionStep;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SingleCellSolutionStrategy implements Function<Grid, Optional<SolutionStep>> {

    private final BiFunction<Grid, Position, Optional<SolutionStep>> solutionStepFinder;

    public SingleCellSolutionStrategy(BiFunction<Grid, Position, Optional<SolutionStep>> solutionStepFinder) {
        this.solutionStepFinder = solutionStepFinder;
    }

    @Override
    public Optional<SolutionStep> apply(Grid grid) {
        Integer dimension = GridExtractors.sizeExtractor.apply(grid);

        return IntStream.range(0, dimension).boxed()
                        .flatMap(rowIndex -> IntStream.range(0, dimension).boxed()
                                                      .flatMap(columnIndex -> solutionStepFinder.apply(grid, new Position(rowIndex, columnIndex)).stream()))
                        .findFirst();
    }
}
