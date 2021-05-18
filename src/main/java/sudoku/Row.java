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

    public boolean findOneNumber() {
        Set<Integer> valuesAlreadyPresent = getCells().stream()
                .filter(CellV2::hasValue)
                .map(CellV2::getValue)
                .map(Optional::get)
                .collect(Collectors.toSet());

        if (onlyAnEmptyCell(valuesAlreadyPresent)) {
            CellV2 emptyCell = getCells()
                    .stream()
                    .filter(cellV2 -> !cellV2.hasValue())
                    .findFirst()
                    .get();

            Set<Integer> allPossibleValues = IntStream.range(1, size() + 1).boxed().collect(Collectors.toSet());

            allPossibleValues.removeAll(valuesAlreadyPresent);

            emptyCell.setValue(allPossibleValues.stream().findFirst().get());

            return true;
        }

        return false;
    }

    private boolean onlyAnEmptyCell(Set<Integer> valuesAlreadyPresent) {
        return size() == valuesAlreadyPresent.size() + 1;
    }
}
