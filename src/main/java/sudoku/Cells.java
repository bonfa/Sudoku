package sudoku;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cells {

    private final List<Cell> cells;

    public Cells(List<Cell> cells) {
        this.cells = cells;
    }

    public boolean canSolve() {
        return valuesNotYetPresent().size() == 1;
    }

    public void solve() {
        emptyCells().get(0).setValue(valuesNotYetPresent().stream().findFirst().get());
    }

    public List<Cell> getCells() {
        return cells;
    }

    private Set<Integer> valuesNotYetPresent() {
        return difference(allPossibleValues(), valuesAlreadyPresent());
    }

    private Set<Integer> allPossibleValues() {
        return IntStream.rangeClosed(1, cells.size()).boxed().collect(Collectors.toSet());
    }

    private Set<Integer> valuesAlreadyPresent() {
        return cells.stream().flatMap(c -> c.getValue().stream()).collect(Collectors.toSet());
    }

    private List<Cell> emptyCells() {
        return cells.stream().filter(cell -> cell.getValue().isEmpty()).collect(Collectors.toList());
    }

    private static Set<Integer> difference(Set<Integer> first, Set<Integer> second) {
        Set<Integer> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }
}
