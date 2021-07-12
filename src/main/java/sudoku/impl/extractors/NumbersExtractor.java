package sudoku.impl.extractors;

import sudoku.impl.models.Grid;
import sudoku.impl.models.Numbers;
import sudoku.impl.models.Zone;

import java.util.function.Function;

import static java.util.stream.Collectors.toSet;
import static sudoku.impl.extractors.GridExtractors.sizeExtractor;
import static sudoku.impl.utilities.Ranges.rangeClosedOfSize;

public class NumbersExtractor {
    public static Function<Zone, Numbers> valuesAlreadyPresent =
            (Zone zone) -> Numbers.of(zone.cells.stream().flatMap(c -> c.getValue().stream()).collect(toSet()));

    public static Function<Grid, Numbers> allPossibleValues = sizeExtractor.andThen(rangeClosedOfSize);

}
