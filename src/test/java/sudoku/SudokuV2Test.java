package sudoku;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.CellV2.cellWithValue;
import static sudoku.CellV2.emptyCell;

class SudokuV2Test {

    @Test
    void singleCellNotSolved() {
        SudokuV2 sudokuV2 = new SudokuV2(List.of(cellsWith(emptyCell())),
                                         List.of(cellsWith(emptyCell())),
                                         List.of(cellsWith(emptyCell())));

        assertFalse(sudokuV2.isSolved());
    }

    @Test
    void singleCellSolved() {
        SudokuV2 sudokuV2 = new SudokuV2(List.of(cellsWith(cellWithValue(1))),
                                         List.of(cellsWith(cellWithValue(1))),
                                         List.of(cellsWith(cellWithValue(1))));

        assertTrue(sudokuV2.isSolved());
    }

    @Test
    void twoCellsNotSolved() { //with 2 cells, the square equals to the row (or the column, it depends on what you decide (not both))
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        cellsWith(emptyCell(), cellWithValue(1)),
                        cellsWith(cellWithValue(1), cellWithValue(2))
                ),
                List.of(
                        cellsWith(emptyCell(), cellWithValue(1)),
                        cellsWith(cellWithValue(1), cellWithValue(2))
                ),
                List.of(
                        cellsWith(emptyCell(), cellWithValue(1)),
                        cellsWith(cellWithValue(1), cellWithValue(2))
                )
        );

        assertFalse(sudokuV2.isSolved());
    }

    @Test
    void twoCellsSolved() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        cellsWith(cellWithValue(2), cellWithValue(1)),
                        cellsWith(cellWithValue(1), cellWithValue(2))
                ),
                List.of(
                        cellsWith(cellWithValue(2), cellWithValue(1)),
                        cellsWith(cellWithValue(1), cellWithValue(2))
                ),
                List.of(
                        cellsWith(cellWithValue(2), cellWithValue(1)),
                        cellsWith(cellWithValue(1), cellWithValue(2))
                )
        );

        assertTrue(sudokuV2.isSolved());
    }

    @Test
    void singleCellSolve() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(cellsWith(emptyCell())),
                List.of(cellsWith(emptyCell())),
                List.of(cellsWith(emptyCell()))
        );

        sudokuV2.setOneNumber();

        assertTrue(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells(), List.of(List.of(cellWithValue(1))));
    }

    @Test
    void solveSimpleRow() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(cellsWith(emptyCell(), cellWithValue(1))),
                List.of(),
                List.of());

        sudokuV2.setOneNumber();

        assertTrue(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells(), List.of(List.of(cellWithValue(2), cellWithValue(1))));
    }

    @Test
    void solveSecondRow() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        cellsWith(emptyCell(), emptyCell()),
                        cellsWith(cellWithValue(1), emptyCell())
                ),
                List.of(
                        cellsWith(emptyCell(), emptyCell()),
                        cellsWith(cellWithValue(1), emptyCell())
                ),
                List.of(
                        cellsWith(emptyCell(), emptyCell()),
                        cellsWith(cellWithValue(1), emptyCell())
                )
        );

        sudokuV2.setOneNumber();

        assertFalse(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells().get(1), List.of(cellWithValue(1), cellWithValue(2)));
    }

    @Test
    void oneStepSolveJustOneRow() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        cellsWith(cellWithValue(1), emptyCell()),
                        cellsWith(cellWithValue(1), emptyCell())
                ),
                List.of(
                        cellsWith(cellWithValue(1), emptyCell()),
                        cellsWith(cellWithValue(1), emptyCell())
                ),
                List.of(
                        cellsWith(cellWithValue(1), emptyCell()),
                        cellsWith(cellWithValue(1), emptyCell())
                )
        );

        sudokuV2.setOneNumber();

        assertFalse(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells().get(0), List.of(cellWithValue(1), cellWithValue(2)));
        assertEquals(sudokuV2.getCells().get(1), List.of(cellWithValue(1), emptyCell()));
    }

    @Test
    void solveSimpleColumn() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        cellsWith(cellWithValue(1), cellWithValue(2)),
                        cellsWith(emptyCell(), cellWithValue(1))
                ),
                List.of(
                        cellsWith(cellWithValue(1), cellWithValue(2)),
                        cellsWith(emptyCell(), cellWithValue(1))
                ),
                List.of(
                        cellsWith(cellWithValue(1), cellWithValue(2)),
                        cellsWith(emptyCell(), cellWithValue(1))
                )
        );

        sudokuV2.setOneNumber();

        assertTrue(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells(), List.of(List.of(cellWithValue(1), cellWithValue(2)),
                                                  List.of(cellWithValue(2), cellWithValue(1))));
    }

    @Disabled
    @Test
    void solveColumnTwoSteps() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        cellsWith(cellWithValue(1), cellWithValue(2)),
                        cellsWith(emptyCell(), emptyCell())
                ),
                List.of(
                        cellsWith(cellWithValue(1), cellWithValue(2)),
                        cellsWith(emptyCell(), emptyCell())
                ),
                List.of(
                        cellsWith(cellWithValue(1), cellWithValue(2)),
                        cellsWith(emptyCell(), emptyCell())
                )
        );

        sudokuV2.setOneNumber();

        assertFalse(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells(), List.of(List.of(cellWithValue(1), cellWithValue(2)),
                                                  List.of(cellWithValue(2), emptyCell())));
    }

    @Disabled
    @Test
    void solveUsingRowsAndColumnsTogether() {
        SudokuV2 sudokuV2 = new SudokuV2(
                List.of(
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell())
                ),
                List.of(
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell())
                ),
                List.of(
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), cellWithValue(2), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell()),
                        cellsWith(emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell(), emptyCell())
                )
        );

        sudokuV2.setOneNumber();

        assertFalse(sudokuV2.isSolved());
        assertEquals(sudokuV2.getCells().get(0).get(0), cellWithValue(2));
    }

    private Cells cellsWith(CellV2... cells) {
        return new Cells(List.of(cells));
    }

}