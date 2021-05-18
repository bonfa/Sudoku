package sudoku;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {
    private final List<CellV2> cells;

    public Row(List<CellV2> cells) {
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
            CellV2 theSingleEmptyCell = emptyCells().stream().findFirst().get();
            Set<Integer> values = allPossibleValues();
            values.removeAll(valuesAlreadyPresent());
            theSingleEmptyCell.setValue(values.stream().findFirst().get());
            return true;
        }
        return false;
    }

    private Set<Integer> allPossibleValues() {
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
}
