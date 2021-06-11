package sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.Cell.*;

class SudokuTest {

    @Test
    void creation() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0)));

        Sudoku sudoku = new Sudoku(cells);

        assertEquals(cells, sudoku.getCells());
    }

    @Test
    void notSolved() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0)));

        Sudoku sudoku = new Sudoku(cells);

        assertFalse(sudoku.isSolved());
    }

    @Test
    void isSolved() {
        List<List<Cell>> cells = List.of(List.of(cellWithValue(0, 0, 4)));

        Sudoku sudoku = new Sudoku(cells);

        assertTrue(sudoku.isSolved());
    }
}