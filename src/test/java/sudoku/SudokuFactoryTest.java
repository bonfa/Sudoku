package sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static sudoku.CellV2.*;

class SudokuFactoryTest {

    @Test
    void singleCell() {
        SudokuFactory sudokuFactory = new SudokuFactory();

        List<List<CellV2>> expectedCells = List.of(List.of(emptyCell()));

        Assertions.assertEquals(new SudokuV2(expectedCells), sudokuFactory.emptySudoku(1, 1));
    }

    @Test
    void twoCells() {
        SudokuFactory sudokuFactory = new SudokuFactory();

        List<List<CellV2>> expectedCells =
                List.of(
                        List.of(emptyCell(), emptyCell())
                );

        Assertions.assertEquals(new SudokuV2(expectedCells), sudokuFactory.emptySudoku(1, 2));
    }

    @Test
    void twoVerticalCells() {
        SudokuFactory sudokuFactory = new SudokuFactory();

        List<List<CellV2>> expectedCells =
                List.of(
                        List.of(emptyCell()),
                        List.of(emptyCell())
                );

        Assertions.assertEquals(new SudokuV2(expectedCells), sudokuFactory.emptySudoku(2,1));
    }

    @Test
    void moreComplexCase() {
        SudokuFactory sudokuFactory = new SudokuFactory();

        List<List<CellV2>> expectedCells =
                List.of(
                        List.of(emptyCell(), emptyCell(), emptyCell()),
                        List.of(emptyCell(), emptyCell(), emptyCell())
                );

        Assertions.assertEquals(new SudokuV2(expectedCells), sudokuFactory.emptySudoku(2,3));
    }

}