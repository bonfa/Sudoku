package sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.Cell.cellWithValue;
import static sudoku.Cell.emptyCell;

class RowTest {

    @Test
    void canBeSolved() {
        Row row = new Row(List.of(emptyCell(0, 0), cellWithValue(0, 1, 1)));

        assertTrue(row.canSolve());
    }

    @Test
    void tooFewCellsToSolve() {
        Row row = new Row(List.of(emptyCell(0, 0), emptyCell(0, 1)));

        assertFalse(row.canSolve());
    }

    @Test
    void alreadySolved() {
        Row row = new Row(List.of(cellWithValue(0, 0, 1), cellWithValue(0, 1, 2)));

        assertFalse(row.canSolve());
    }

    @Test
    void solveSingleCell() {
        Row row = new Row(List.of(emptyCell(0, 0)));

        row.solve();

        assertEquals(1, row.getCells().get(0).getValue().get());
    }

    @Test
    void solveTwoCells() {
        Row row = new Row(List.of(emptyCell(0, 0), cellWithValue(0, 1, 2)));

        row.solve();

        assertEquals(1, row.getCells().get(0).getValue().get());
        assertEquals(2, row.getCells().get(1).getValue().get());
    }

    @Test
    void solveTwoCells_2() {
        Row row = new Row(List.of(emptyCell(0, 0), cellWithValue(0, 1, 1)));

        row.solve();

        assertEquals(2, row.getCells().get(0).getValue().get());
        assertEquals(1, row.getCells().get(1).getValue().get());
    }

    @Test
    void solveTwoCells_3() {
        Row row = new Row(List.of(cellWithValue(0, 0, 1), emptyCell(0, 1)));

        row.solve();

        assertEquals(1, row.getCells().get(0).getValue().get());
        assertEquals(2, row.getCells().get(1).getValue().get());
    }

    @Test
    void solveTwoCells_4() {
        Row row = new Row(List.of(cellWithValue(0, 0, 2), emptyCell(0, 1)));

        row.solve();

        assertEquals(2, row.getCells().get(0).getValue().get());
        assertEquals(1, row.getCells().get(1).getValue().get());
    }

    @Test
    void solveRowOfArbitraryLength() {
        Row row = new Row((List.of(cellWithValue(0, 0, 1),
                                   cellWithValue(0, 1, 2),
                                   cellWithValue(0, 2, 3),
                                   cellWithValue(0, 3, 4),
                                   emptyCell(0, 4))));


        row.solve();

        assertEquals(1, row.getCells().get(0).getValue().get());
        assertEquals(2, row.getCells().get(1).getValue().get());
        assertEquals(3, row.getCells().get(2).getValue().get());
        assertEquals(4, row.getCells().get(3).getValue().get());
        assertEquals(5, row.getCells().get(4).getValue().get());
    }
}