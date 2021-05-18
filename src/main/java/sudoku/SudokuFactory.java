package sudoku;

import java.util.Collections;
import java.util.stream.Collectors;

public class SudokuFactory {
    public SudokuV2 emptySudoku(int numberOfRows, int numberOfColumns) {
        return new SudokuV2(Collections.nCopies(numberOfRows, Collections.nCopies(numberOfColumns, CellV2.emptyCell()))
                                       .stream()
                                       .map(Row::new)
                                       .collect(Collectors.toList()));
    }

    //todo finish with the proper methods
}

