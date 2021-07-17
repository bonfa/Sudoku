package sudoku.impl.strategy;

import sudoku.impl.models.Grid;
import sudoku.impl.models.Position;
import sudoku.impl.models.SolutionStep;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static sudoku.impl.extractors.GridExtractors.extractSize;
import static sudoku.impl.strategy.impl.CellWithSingleCandidate.getSolutionStep;

public class SingleCellSolutionStrategy {
    private static final Function<Integer, List<Position>> allPossiblePositions =
            (Integer dimension) -> IntStream.range(0, dimension).boxed()
                                            .flatMap(rowIndex -> IntStream.range(0, dimension)
                                                                          .boxed()
                                                                          .map(columnIndex -> new Position(rowIndex,
                                                                                                           columnIndex)))
                                            .collect(toList());

    private static final Function<Grid, Function<List<Position>, Optional<SolutionStep>>> dunno3 = (Grid grid) -> (List<Position> positions) ->
            positions.stream()
                     .map(p -> getSolutionStep.apply(grid, p))
                     .flatMap(Optional::stream)
                     .findFirst();

    private static final Function<Grid, List<Position>> extractAllPossiblePositions = extractSize.andThen(allPossiblePositions);

    public static final Function<Grid, Optional<SolutionStep>> getFirstSolutionStep =
            (Grid grid) -> dunno3.apply(grid).apply(extractAllPossiblePositions.apply(grid));
}
