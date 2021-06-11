package deprecated;

import java.util.Objects;
import java.util.Optional;

public class CellV2 {
    private Integer value;

    private CellV2(Integer value) {
        this.value = value;
    }

    public boolean hasValue() {
        return value != null;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Optional<Integer> getValue() {
        return Optional.ofNullable(value);
    }

    public static CellV2 emptyCell() {
        return new CellV2(null);
    }

    public static CellV2 cellWithValue(Integer value) {
        return new CellV2(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellV2 cellV2 = (CellV2) o;
        return Objects.equals(value, cellV2.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CellV2{" +
                "value=" + value +
                '}';
    }
}
