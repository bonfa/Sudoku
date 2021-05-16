package sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static sudoku.CellV2.*;

class SudokuFactoryTest {

    private final SudokuFactory sudokuFactory = new SudokuFactory();

    @Test
    void singleCell() {
        List<List<CellV2>> expectedCells = List.of(List.of(emptyCell()));

        SudokuV2 sudoku = sudokuFactory.emptySudoku(1, 1);

        Assertions.assertEquals(expectedCells, sudoku.getCells());
    }

    @Test
    void twoCells() {
        List<List<CellV2>> expectedCells =
                List.of(
                        List.of(emptyCell(), emptyCell())
                );

        SudokuV2 sudoku = sudokuFactory.emptySudoku(1, 2);

        Assertions.assertEquals(expectedCells, sudoku.getCells());
    }

    @Test
    void twoVerticalCells() {
        List<List<CellV2>> expectedCells =
                List.of(
                        List.of(emptyCell()),
                        List.of(emptyCell())
                );

        SudokuV2 sudoku = sudokuFactory.emptySudoku(2, 1);

        Assertions.assertEquals(expectedCells, sudoku.getCells());
    }

    @Test
    void moreComplexCase() {
        List<List<CellV2>> expectedCells =
                List.of(
                        List.of(emptyCell(), emptyCell(), emptyCell()),
                        List.of(emptyCell(), emptyCell(), emptyCell())
                );

        SudokuV2 sudoku = sudokuFactory.emptySudoku(2, 3);

        Assertions.assertEquals(expectedCells, sudoku.getCells());
    }
}