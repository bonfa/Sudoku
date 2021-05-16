package sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static sudoku.CellV2.*;

class SudokuV2Test {

    @Test
    void singleCell() {
        SudokuV2 sudokuV2 = new SudokuV2(1, 1);

        List<List<CellV2>> expected = List.of(List.of(emptyCell()));

        Assertions.assertEquals(expected, sudokuV2.getCells());
    }

    @Test
    void twoCells() {
        SudokuV2 sudokuV2 = new SudokuV2(1, 2);

        List<List<CellV2>> expected =
                List.of(
                        List.of(emptyCell(), emptyCell())
                );

        Assertions.assertEquals(expected, sudokuV2.getCells());
    }

    @Test
    void twoVerticalCells() {
        SudokuV2 sudokuV2 = new SudokuV2(2, 1);

        List<List<CellV2>> expected =
                List.of(
                        List.of(emptyCell()),
                        List.of(emptyCell())
                );

        Assertions.assertEquals(expected, sudokuV2.getCells());
    }

    @Test
    void moreComplexCase() {
        SudokuV2 sudokuV2 = new SudokuV2(2, 3);

        List<List<CellV2>> expected =
                List.of(
                        List.of(emptyCell(), emptyCell(), emptyCell()),
                        List.of(emptyCell(), emptyCell(), emptyCell())
                );

        Assertions.assertEquals(expected, sudokuV2.getCells());
    }
}