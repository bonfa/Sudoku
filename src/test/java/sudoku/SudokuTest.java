package sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.Cell.cellWithValue;
import static sudoku.Cell.emptyCell;

class SudokuTest {

    @Test
    void creation() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0)));

        Sudoku sudoku = new Sudoku(new Grid(cells));

        assertEquals(cells, sudoku.getCells());
    }

    @Test
    void notSolved() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0)));

        Sudoku sudoku = new Sudoku(new Grid(cells));

        assertFalse(sudoku.isSolved());
    }

    @Test
    void solved() {
        List<List<Cell>> cells = List.of(List.of(cellWithValue(0, 0, 4)));

        Sudoku sudoku = new Sudoku(new Grid(cells));

        assertTrue(sudoku.isSolved());
    }

    @Test
    void oneCellSolve() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertTrue(sudoku.isSolved());
        assertEquals(1, sudoku.getCells().get(0).get(0).getValue().get());
    }

    @Test
    void twoCellsSolveByRow() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0), cellWithValue(0, 1, 1)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertTrue(sudoku.isSolved());
        assertEquals(2, sudoku.getCells().get(0).get(0).getValue().get());
        assertEquals(1, sudoku.getCells().get(0).get(1).getValue().get());
    }

    @Test
    void twoCellsSolveByRow_2() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0), cellWithValue(0, 1, 2)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertTrue(sudoku.isSolved());
        assertEquals(1, sudoku.getCells().get(0).get(0).getValue().get());
        assertEquals(2, sudoku.getCells().get(0).get(1).getValue().get());
    }

    @Test
    void twoCellsSolveByRow_3() {
        List<List<Cell>> cells = List.of(List.of(cellWithValue(0, 0, 1), emptyCell(0, 1)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertTrue(sudoku.isSolved());
        assertEquals(1, sudoku.getCells().get(0).get(0).getValue().get());
        assertEquals(2, sudoku.getCells().get(0).get(1).getValue().get());
    }

    @Test
    void twoCellsSolveByRow_4() {
        List<List<Cell>> cells = List.of(List.of(cellWithValue(0, 0, 2), emptyCell(0, 1)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertTrue(sudoku.isSolved());
        assertEquals(2, sudoku.getCells().get(0).get(0).getValue().get());
        assertEquals(1, sudoku.getCells().get(0).get(1).getValue().get());
    }

    @Test
    void solveRowOfArbitraryLengthWithOneCellMissing() {
        List<List<Cell>> cells = List.of(List.of(cellWithValue(0, 0, 1),
                                                 cellWithValue(0, 1, 2),
                                                 cellWithValue(0, 2, 3),
                                                 cellWithValue(0, 3, 4),
                                                 emptyCell(0, 4)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertTrue(sudoku.isSolved());
        assertEquals(1, sudoku.getCells().get(0).get(0).getValue().get());
        assertEquals(2, sudoku.getCells().get(0).get(1).getValue().get());
        assertEquals(3, sudoku.getCells().get(0).get(2).getValue().get());
        assertEquals(4, sudoku.getCells().get(0).get(3).getValue().get());
        assertEquals(5, sudoku.getCells().get(0).get(4).getValue().get());
    }

    @Test
    void solvingARowAlreadySolved() {
        List<List<Cell>> cells = List.of(List.of(cellWithValue(0, 0, 1),
                                                 cellWithValue(0, 1, 2),
                                                 cellWithValue(0, 2, 3),
                                                 cellWithValue(0, 3, 4)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertTrue(sudoku.isSolved());
        assertEquals(1, sudoku.getCells().get(0).get(0).getValue().get());
        assertEquals(2, sudoku.getCells().get(0).get(1).getValue().get());
        assertEquals(3, sudoku.getCells().get(0).get(2).getValue().get());
        assertEquals(4, sudoku.getCells().get(0).get(3).getValue().get());
    }

    @Test
    void cannotSolveByRow() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0),
                                                 emptyCell(0, 1),
                                                 cellWithValue(0, 2, 3),
                                                 cellWithValue(0, 3, 4)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertFalse(sudoku.isSolved());
        assertTrue(sudoku.getCells().get(0).get(0).getValue().isEmpty());
        assertTrue(sudoku.getCells().get(0).get(1).getValue().isEmpty());
        assertEquals(3, sudoku.getCells().get(0).get(2).getValue().get());
        assertEquals(4, sudoku.getCells().get(0).get(3).getValue().get());
    }

    @Test
    void solveSecondRow() {
        List<List<Cell>> cells = List.of(List.of(emptyCell(0, 0), emptyCell(0, 1)),
                                         List.of(cellWithValue(1, 0, 1), emptyCell(1, 1)));

        Sudoku sudoku = new Sudoku(new Grid(cells));
        sudoku.setOneNumber();

        assertFalse(sudoku.isSolved());
        assertTrue(sudoku.getCells().get(0).get(0).getValue().isEmpty());
        assertTrue(sudoku.getCells().get(0).get(1).getValue().isEmpty());
        assertEquals(1, sudoku.getCells().get(1).get(0).getValue().get());
        assertEquals(2, sudoku.getCells().get(1).get(1).getValue().get());
    }
}