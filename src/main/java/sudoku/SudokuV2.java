package sudoku;

import java.util.Collections;
import java.util.List;

public class SudokuV2 {
    private final int numberOfRows;
    private final int numberOfColumns;

    public SudokuV2(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public List<List<CellV2>> getCells() {
        return Collections.nCopies(numberOfRows, Collections.nCopies(numberOfColumns, CellV2.emptyCell()));
    }
}
