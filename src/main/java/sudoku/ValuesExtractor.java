package sudoku;

import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class ValuesExtractor {
    public static Function<Zone, Numbers> valuesAlreadyPresent =
            (Zone zone) -> Numbers.of(zone.cells.stream().flatMap(c -> c.getValue().stream()).collect(toSet()));

    public static Function<Grid, Numbers> allPossibleValues =
            (Grid grid) -> Numbers.of(IntStream.rangeClosed(1, grid.getDimensions().rows).boxed().collect(toSet()));

}
