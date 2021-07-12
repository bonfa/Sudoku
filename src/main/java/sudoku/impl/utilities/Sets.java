package sudoku.impl.utilities;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static Set<Integer> sum(Set<Integer>... sets) {
        Set<Integer> addition = new HashSet<>();
        Arrays.stream(sets).forEach(addition::addAll);
        return addition;
    }

    public static Set<Integer> difference(Set<Integer> first, Set<Integer> second) {
        Set<Integer> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }
}
