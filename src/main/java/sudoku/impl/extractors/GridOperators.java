package sudoku.impl.extractors;

import sudoku.models.Cell;
import sudoku.models.Grid;
import sudoku.models.SolutionStep;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static sudoku.impl.extractors.GridExtractors.extractCells;

public class GridOperators {
    private static final UnaryOperator<List<List<Cell>>> toMutable =
            (List<List<Cell>> cells) ->
                    cells.stream()
                         .map(ArrayList::new)
                         .collect(Collectors.toList());

    private static final Function<List<List<Cell>>, Function<Cell, List<List<Cell>>>> setCell =
            (List<List<Cell>> originals) -> (Cell cell) -> {
                List<List<Cell>> copy = toMutable.apply(originals);

                copy.get(cell.getPosition().rowIndex)
                    .set(cell.getPosition().columnIndex, cell);

                return copy;
            };

    private static final Function<SolutionStep, Cell> solutionStepToCell =
            (SolutionStep solutionStep) -> Cell.cellWithValue(solutionStep.value, solutionStep.position);

    public static final Function<Grid, Function<SolutionStep, Grid>> updateGrid =
            extractCells.andThen(setCell)
                        .andThen(cellListFunction -> cellListFunction.andThen(Grid::new))
                        .andThen(gridFunction -> gridFunction.compose(solutionStepToCell));
}
