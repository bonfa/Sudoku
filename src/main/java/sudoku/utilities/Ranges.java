package sudoku.utilities;

import sudoku.models.Numbers;

import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Ranges {
    public static Function<Integer, Numbers> rangeClosedOfSize =
            (Integer size) -> Numbers.of(IntStream.rangeClosed(1, size).boxed().collect(toSet()));
}
