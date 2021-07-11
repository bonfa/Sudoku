package sudoku;

import sudoku.models.Grid;
import sudoku.models.Numbers;
import sudoku.models.Zone;

import java.util.function.Function;

import static java.util.stream.Collectors.toSet;
import static sudoku.GridExtractors.*;
import static sudoku.utilities.Ranges.*;

public class NumbersExtractor {
    public static Function<Zone, Numbers> valuesAlreadyPresent =
            (Zone zone) -> Numbers.of(zone.cells.stream().flatMap(c -> c.getValue().stream()).collect(toSet()));

    public static Function<Grid, Numbers> allPossibleValues = sizeExtractor.andThen(rangeClosedOfSize);

}
