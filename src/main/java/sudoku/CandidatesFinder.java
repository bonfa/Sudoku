package sudoku;

import sudoku.models.Grid;
import sudoku.models.Numbers;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static sudoku.NumbersOperators.difference;
import static sudoku.NumbersOperators.sum;
import static sudoku.ValuesExtractor.allPossibleValues;
import static sudoku.ValuesExtractor.valuesAlreadyPresent;
import static sudoku.ZoneExtractors.*;

public class CandidatesFinder implements BiFunction<Grid, Grid.Position, Numbers> {

    private final BiFunction<Grid, Grid.Position, Numbers> valuesAlreadyPresentInRow = rowExtractor.andThen(valuesAlreadyPresent);
    private final BiFunction<Grid, Grid.Position, Numbers> valuesAlreadyPresentInColumn = columnExtractor.andThen(valuesAlreadyPresent);
    private final BiFunction<Grid, Grid.Position, Numbers> valuesAlreadyPresentInSquare = squareExtractor.andThen(valuesAlreadyPresent);

    @Override
    public Numbers apply(Grid grid, Grid.Position position) {
        return (grid.cellAt(position).getValue().isPresent()) ?
                Numbers.empty() :
                difference(allPossibleValues(), valuesAlreadyPresent()).apply(grid, position);
    }

    private BiFunction<Grid, Grid.Position, Numbers> difference(BiFunction<Grid, Grid.Position, Numbers> allPossibleValues, BiFunction<Grid, Grid.Position, Numbers> valuesAlreadyPresent) {
        return (grid, position) -> difference.apply(allPossibleValues.apply(grid, position),
                                                    valuesAlreadyPresent.apply(grid, position));
    }

    private BiFunction<Grid, Grid.Position, Numbers> allPossibleValues() {
        return (grid, position) -> allPossibleValues.apply(grid);
    }

    private BiFunction<Grid, Grid.Position, Numbers> valuesAlreadyPresent() {
        return Stream.of(valuesAlreadyPresentInRow,
                         valuesAlreadyPresentInColumn,
                         valuesAlreadyPresentInSquare)
                     .reduce((grid, position) -> Numbers.empty(),
                             (first, second) -> (grid, position) -> sum.apply(first.apply(grid, position), second.apply(grid, position)));
    }
}
