package sudoku.impl.strategy.impl;

import sudoku.impl.models.Grid;
import sudoku.impl.models.Numbers;
import sudoku.impl.models.Position;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static sudoku.impl.extractors.CellExtractors.valueExtractor;
import static sudoku.impl.extractors.NumbersOperators.difference;
import static sudoku.impl.extractors.NumbersOperators.sum;
import static sudoku.impl.extractors.NumbersExtractor.allPossibleValues;
import static sudoku.impl.extractors.NumbersExtractor.valuesAlreadyPresent;
import static sudoku.impl.extractors.GridExtractors.*;
import static sudoku.impl.utilities.Optionals.valueIsPresent;

public class CandidatesFinder implements BiFunction<Grid, Position, Numbers> {

    private final BiFunction<Grid, Position, Numbers> valuesAlreadyPresentInRow = rowExtractor.andThen(valuesAlreadyPresent);
    private final BiFunction<Grid, Position, Numbers> valuesAlreadyPresentInColumn = columnExtractor.andThen(valuesAlreadyPresent);
    private final BiFunction<Grid, Position, Numbers> valuesAlreadyPresentInSquare = squareExtractor.andThen(valuesAlreadyPresent);

    @Override
    public Numbers apply(Grid grid, Position position) {
        return valueIsPresent.test(cellExtractor.andThen(valueExtractor).apply(grid, position)) ?
                Numbers.empty() :
                difference(allPossibleValues(), valuesAlreadyPresent()).apply(grid, position);
    }

    private BiFunction<Grid, Position, Numbers> difference(BiFunction<Grid, Position, Numbers> allPossibleValues, BiFunction<Grid, Position, Numbers> valuesAlreadyPresent) {
        return (grid, position) -> difference.apply(allPossibleValues.apply(grid, position),
                                                    valuesAlreadyPresent.apply(grid, position));
    }

    private BiFunction<Grid, Position, Numbers> allPossibleValues() {
        return (grid, position) -> allPossibleValues.apply(grid);
    }

    private BiFunction<Grid, Position, Numbers> valuesAlreadyPresent() {
        return Stream.of(valuesAlreadyPresentInRow,
                         valuesAlreadyPresentInColumn,
                         valuesAlreadyPresentInSquare)
                     .reduce((grid, position) -> Numbers.empty(),
                             (first, second) -> (grid, position) -> sum.apply(first.apply(grid, position), second.apply(grid, position)));
    }
}
