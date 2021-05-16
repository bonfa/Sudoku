package sudoku;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuV2 {
    private List<List<CellV2>> cells;

    public SudokuV2(List<List<CellV2>> cells) {
        this.cells = cells;
    }

    public List<List<CellV2>> getCells() {
        return List.copyOf(cells);
    }

    public boolean isSolved() {
        return cells.stream().allMatch(c -> c.stream().allMatch(CellV2::hasValue));
    }

    public void findOneNumber() {
        if (cells.size() == 1 && cells.get(0).size() == 1) {
            cells = List.of(List.of(CellV2.cellWithValue(1)));
        }

        for (List<CellV2> row: cells) {
            if (solveSingleRow(row))
                return;
        }
    }

    private boolean solveSingleRow(List<CellV2> firstRow) {
        Set<Integer> valuesAlreadyPresent = firstRow.stream()
                                                    .filter(CellV2::hasValue)
                                                    .map(CellV2::getValue)
                                                    .map(Optional::get)
                                                    .collect(Collectors.toSet());

        if (onlyAnEmptyCell(firstRow, valuesAlreadyPresent))
        {
            CellV2 emptyCell = firstRow.stream()
                                       .filter(cellV2 -> !cellV2.hasValue())
                                       .findFirst()
                                       .get();

            Set<Integer> allPossibleValues = IntStream.range(1, firstRow.size() + 1).boxed().collect(Collectors.toSet());

            allPossibleValues.removeAll(valuesAlreadyPresent);

            emptyCell.setValue(allPossibleValues.stream().findFirst().get());

            return true;
        }

        return false;
    }

    private boolean onlyAnEmptyCell(List<CellV2> firstRow, Set<Integer> valuesAlreadyPresent) {
        return firstRow.size() == valuesAlreadyPresent.size() + 1;
    }
}
