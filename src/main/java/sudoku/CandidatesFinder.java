package sudoku;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static sudoku.ConditionalOperations.iff;
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
        return createFunction().apply(grid, position);
    }

    private BiFunction<Grid, Grid.Position, Numbers> createFunction() {
        return iff.apply((grid, position) -> grid.cellAt(position).getValue().isPresent(),
                         (grid, position) -> Numbers.empty(),
                         (grid, position) -> difference(allPossibleValues(), valuesAlreadyPresent()).apply(grid, position));
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
