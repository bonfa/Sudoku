package sudoku.impl.strategy;

import sudoku.impl.models.Grid;
import sudoku.impl.models.SolutionStep;

import java.util.Optional;
import java.util.function.Function;

import static sudoku.impl.extractors.GridExtractors.extractAllPossiblePositions;
import static sudoku.impl.strategy.impl.CellWithSingleCandidate.getSolutionStep;

public class SingleCellSolutionStrategy {

    public static final Function<Grid, Optional<SolutionStep>> getFirstSolutionStep =
            (Grid grid) -> extractAllPossiblePositions.apply(grid)
                                                      .stream()
                                                      .map(p -> getSolutionStep.apply(grid, p))
                                                      .flatMap(Optional::stream)
                                                      .findFirst();
}
