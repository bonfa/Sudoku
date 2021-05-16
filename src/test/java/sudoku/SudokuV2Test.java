package sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.CellV2.cellWithValue;
import static sudoku.CellV2.emptyCell;

class SudokuV2Test {

    @Test
    void singleCellNotSolved() {
        SudokuV2 sudokuV2 = new SudokuV2(List.of(List.of(emptyCell())));

        assertFalse(sudokuV2.isSolved());
    }

    @Test
    void singleCellSolved() {
        SudokuV2 sudokuV2 = new SudokuV2(List.of(List.of(cellWithValue(1))));

        assertTrue(sudokuV2.isSolved());
    }

    @Test
    void manyCellsNotSolved() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        List.of(emptyCell(), cellWithValue(1)),
                        List.of(cellWithValue(1), cellWithValue(2))
                        )
        );

        assertFalse(sudokuV2.isSolved());
    }

    @Test
    void manyCellsSolved() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        List.of(cellWithValue(2), cellWithValue(1)),
                        List.of(cellWithValue(1), cellWithValue(2))
                )
        );

        assertTrue(sudokuV2.isSolved());
    }

    @Test
    void singleCellSolve() {
        SudokuV2 sudokuV2 = new SudokuV2(List.of(List.of(emptyCell())));

        sudokuV2.findOneNumber();

        assertTrue(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells(), List.of(List.of(cellWithValue(1))));
    }

    @Test
    void solveSimpleRow() {
        SudokuV2 sudokuV2 = new SudokuV2(List.of(List.of(emptyCell(), cellWithValue(1))));

        sudokuV2.findOneNumber();

        assertTrue(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells(), List.of(List.of(cellWithValue(2), cellWithValue(1))));
    }

    @Test
    void solveSecondRow() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        List.of(emptyCell(), emptyCell()),
                        List.of(cellWithValue(1), emptyCell())
                )
        );

        sudokuV2.findOneNumber();

        assertFalse(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells().get(1), List.of(cellWithValue(1), cellWithValue(2)));
    }

    @Test
    void oneStepSolveJustOneRow() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        List.of(cellWithValue(1), emptyCell()),
                        List.of(cellWithValue(1), emptyCell())
                )
        );

        sudokuV2.findOneNumber();

        assertFalse(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells().get(0), List.of(cellWithValue(1), cellWithValue(2)));
        assertEquals(sudokuV2.getCells().get(1), List.of(cellWithValue(1), emptyCell()));
    }
}