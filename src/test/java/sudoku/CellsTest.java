package sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.Cell.cellWithValue;
import static sudoku.Cell.emptyCell;

class CellsTest {

    @Test
    void canBeSolved() {
        Cells cells = new Cells(List.of(emptyCell(0, 0), cellWithValue(0, 1, 1)));

        assertTrue(cells.canSolve());
    }

    @Test
    void tooFewCellsToSolve() {
        Cells cells = new Cells(List.of(emptyCell(0, 0), emptyCell(0, 1)));

        assertFalse(cells.canSolve());
    }

    @Test
    void alreadySolved() {
        Cells cells = new Cells(List.of(cellWithValue(0, 0, 1), cellWithValue(0, 1, 2)));

        assertFalse(cells.canSolve());
    }

    @Test
    void solveSingleCell() {
        Cells cells = new Cells(List.of(emptyCell(0, 0)));

        cells.solve();

        assertEquals(1, cells.getCells().get(0).getValue().get());
    }

    @Test
    void solveTwoCells() {
        Cells cells = new Cells(List.of(emptyCell(0, 0), cellWithValue(0, 1, 2)));

        cells.solve();

        assertEquals(1, cells.getCells().get(0).getValue().get());
        assertEquals(2, cells.getCells().get(1).getValue().get());
    }

    @Test
    void solveTwoCells_2() {
        Cells cells = new Cells(List.of(emptyCell(0, 0), cellWithValue(0, 1, 1)));

        cells.solve();

        assertEquals(2, cells.getCells().get(0).getValue().get());
        assertEquals(1, cells.getCells().get(1).getValue().get());
    }

    @Test
    void solveTwoCells_3() {
        Cells cells = new Cells(List.of(cellWithValue(0, 0, 1), emptyCell(0, 1)));

        cells.solve();

        assertEquals(1, cells.getCells().get(0).getValue().get());
        assertEquals(2, cells.getCells().get(1).getValue().get());
    }

    @Test
    void solveTwoCells_4() {
        Cells cells = new Cells(List.of(cellWithValue(0, 0, 2), emptyCell(0, 1)));

        cells.solve();

        assertEquals(2, cells.getCells().get(0).getValue().get());
        assertEquals(1, cells.getCells().get(1).getValue().get());
    }

    @Test
    void solveRowOfArbitraryLength() {
        Cells cells = new Cells((List.of(cellWithValue(0, 0, 1),
                                         cellWithValue(0, 1, 2),
                                         cellWithValue(0, 2, 3),
                                         cellWithValue(0, 3, 4),
                                         emptyCell(0, 4))));


        cells.solve();

        assertEquals(1, cells.getCells().get(0).getValue().get());
        assertEquals(2, cells.getCells().get(1).getValue().get());
        assertEquals(3, cells.getCells().get(2).getValue().get());
        assertEquals(4, cells.getCells().get(3).getValue().get());
        assertEquals(5, cells.getCells().get(4).getValue().get());
    }
}