package sudoku;

public class Cell {
    private final int rowIndex;
    private final int columnIndex;
    private final Integer value;

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

    public boolean hasValue() {
        return value != null;
    }
}
