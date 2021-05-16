package sudoku;

import java.util.Collections;

public class SudokuFactory {
    public SudokuV2 emptySudoku(int numberOfRows, int numberOfColumns) {
        return new SudokuV2(Collections.nCopies(numberOfRows, Collections.nCopies(numberOfColumns, CellV2.emptyCell())));
    }

    //todo finish with the proper methods
}

