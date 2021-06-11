package sudoku;

import java.util.Optional;

public class Cell {
    private final int rowIndex;
    private final int columnIndex;
    private Integer value;

    private Cell(int rowIndex, int columnIndex, Integer value) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.value = value;
    }

    public static Cell emptyCell(int rowIndex, int columnIndex) {
        return new Cell(rowIndex, columnIndex, null);
    }

    public static Cell cellWithValue(int rowIndex, int columnIndex, int value) {
        return new Cell(rowIndex, columnIndex, value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Optional<Integer> getValue() {
        return Optional.ofNullable(value);
    }
}
