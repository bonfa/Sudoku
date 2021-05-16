package sudoku;

import java.util.List;
import java.util.Objects;

public class SudokuV2 {
    private final List<List<CellV2>> cells;

    public SudokuV2(List<List<CellV2>> cells) {
        this.cells = cells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuV2 sudokuV2 = (SudokuV2) o;
        return Objects.equals(cells, sudokuV2.cells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cells);
    }
}
