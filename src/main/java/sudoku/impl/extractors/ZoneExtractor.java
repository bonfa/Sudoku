package sudoku.impl.extractors;

import sudoku.models.Numbers;
import sudoku.models.Zone;

import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

public class ZoneExtractor {
    public static Function<Zone, Numbers> valuesAlreadyPresent =
            (Zone zone) -> Numbers.of(zone.cells.stream().flatMap(c -> c.getValue().stream()).collect(toSet()));
}
