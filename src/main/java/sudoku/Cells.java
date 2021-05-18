package sudoku;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cells {
    private final List<CellV2> cells;

    public Cells(List<CellV2> cells) {
        this.cells = cells;
    }

    public List<CellV2> getCells() {
        return cells;
    }

    public int size() {
        return cells.size();
    }

    public boolean isSolved() {
        return cells.stream().allMatch(CellV2::hasValue);
    }

    public boolean setOneNumber() {
        if (isThereOnlyAnEmptyCell()) {
            return emptyCells().stream()
                               .findFirst()
                               .map(this::update)
                               .orElse(false);
        }
        return false;
    }

    private boolean update(CellV2 theSingleEmptyCell) {
        theSingleEmptyCell.setValue(missingValues().stream().findFirst().get());
        return true;
    }

    private Set<Integer> missingValues() {
        return difference(allThePossibleValues(), valuesAlreadyPresent());
    }

    private Set<Integer> allThePossibleValues() {
        return IntStream.range(1, size() + 1).boxed().collect(Collectors.toSet());
    }

    private List<CellV2> emptyCells() {
        return cells.stream()
                    .filter(cellV2 -> !cellV2.hasValue())
                    .collect(Collectors.toList());
    }

    private Set<Integer> valuesAlreadyPresent() {
        return cells.stream()
                    .filter(CellV2::hasValue)
                    .map(CellV2::getValue)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
    }

    private boolean isThereOnlyAnEmptyCell() {
        return size() == valuesAlreadyPresent().size() + 1;
    }

    private static Set<Integer> difference(Set<Integer> first, Set<Integer> second) {
        Set<Integer> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }
}
