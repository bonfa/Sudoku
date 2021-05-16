package sudoku;

import java.util.List;
import java.util.Objects;

public class SudokuV2 {
    private final List<List<CellV2>> cells;

    public SudokuV2(List<List<CellV2>> cells) {
        this.cells = cells;
    }

    public List<List<CellV2>> getCells() {
        return List.copyOf(cells);
    }
}
