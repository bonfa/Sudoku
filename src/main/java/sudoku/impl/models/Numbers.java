package sudoku.impl.models;

import java.util.Collections;
import java.util.Set;

public class Numbers {
    private final Set<Integer> values;

    public Numbers(Set<Integer> values) {
        this.values = values;
    }

    public static Numbers of(Set<Integer> values) {
        return new Numbers(Collections.unmodifiableSet(values));
    }

    public static Numbers empty() {
        return new Numbers(Collections.emptySet());
    }

    public Set<Integer> getValues() {
        return values;
    }
}
