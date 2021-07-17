package sudoku.impl.utilities;

import sudoku.models.Numbers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Ranges {
    public static Function<Integer, List<Integer>> zeroBasedRangeClosed =
            (Integer size) -> IntStream.range(0, size).boxed().collect(toList());

    public static Function<Integer, Numbers> rangeClosed =
            (Integer size) -> Numbers.of(IntStream.rangeClosed(1, size).boxed().collect(toSet()));
}
