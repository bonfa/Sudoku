package sudoku.impl.utilities;

import sudoku.models.Numbers;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Ranges {
    private static final Function<Integer, Function<Integer, Stream<Integer>>> rangeOf =
            (Integer min) -> (Integer max) -> IntStream.range(min, max).boxed();

    private static final Function<Integer, Function<Integer, Stream<Integer>>> rangeClosedOf =
            (Integer min) -> (Integer max) -> IntStream.rangeClosed(min, max).boxed();

    private static final Function<Integer, Stream<Integer>> rangeOfSize = rangeOf.apply(0);
    private static final Function<Integer, Stream<Integer>> rangeClosedStartingFromOne = rangeClosedOf.apply(1);

    private static final Function<Stream<Integer>, List<Integer>> toList = v -> v.collect(toList());
    private static final Function<Stream<Integer>, Set<Integer>> toSet = v -> v.collect(toSet());

    public static final Function<Integer, List<Integer>> listZeroTo = rangeOfSize.andThen(toList);
    public static final Function<Integer, Set<Integer>> setOneTo = rangeClosedStartingFromOne.andThen(toSet);

}
