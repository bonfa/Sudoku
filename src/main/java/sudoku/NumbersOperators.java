package sudoku;

import sudoku.models.Numbers;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersOperators {

    public static BinaryOperator<Numbers> sum =
            (Numbers first, Numbers second) -> Numbers.of(Stream.concat(first.getValues().stream(), second.getValues().stream()).collect(Collectors.toSet()));

    public static BinaryOperator<Numbers> difference =
            (Numbers first, Numbers second) -> {
                Set<Integer> difference = new HashSet<>(first.getValues());
                difference.removeAll(second.getValues());
                return new Numbers(difference);
            };
}
