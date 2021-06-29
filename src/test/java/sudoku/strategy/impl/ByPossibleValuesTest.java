package sudoku.strategy.impl;

import org.junit.jupiter.api.Test;
import sudoku.Grid;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.Cell.cellWithValue;
import static sudoku.Cell.emptyCell;

class ByPossibleValuesTest {

    private final ByPossibleValues strategy = new ByPossibleValues(new ByPossibleValues2());

    @Test
    void canAddOneNumber() {
        Grid grid = new Grid(List.of(
                List.of(cellWithValue(0, 0, 3), emptyCell(0, 1), cellWithValue(0, 2, 4), emptyCell(0, 3)),
                List.of(emptyCell(1, 0), cellWithValue(1, 1, 1), emptyCell(1, 2), cellWithValue(1, 3, 2)),
                List.of(emptyCell(2, 0), cellWithValue(2, 1, 4), emptyCell(2, 2), cellWithValue(2, 3, 3)),
                List.of(cellWithValue(3, 0, 2), emptyCell(3, 1), cellWithValue(3, 2, 1), emptyCell(3, 3))));

        assertTrue(strategy.canAddOneNumber(grid));
    }

    @Test
    void canNotAddOneNumber() {
        Grid grid = new Grid(List.of(
                List.of(emptyCell(0, 0), emptyCell(0, 1), emptyCell(0, 2), emptyCell(0, 3)),
                List.of(emptyCell(1, 0), cellWithValue(1, 1, 1), emptyCell(1, 2), cellWithValue(1, 3, 2)),
                List.of(emptyCell(2, 0), emptyCell(2, 1), emptyCell(2, 2), emptyCell(2, 3)),
                List.of(cellWithValue(3, 0, 2), emptyCell(3, 1), cellWithValue(3, 2, 1), emptyCell(3, 3))));

        assertFalse(strategy.canAddOneNumber(grid));
    }

    @Test
    void addOneNumber() {
        Grid grid = new Grid(List.of(
                List.of(cellWithValue(0, 0, 3), emptyCell(0, 1), cellWithValue(0, 2, 4), emptyCell(0, 3)),
                List.of(emptyCell(1, 0), cellWithValue(1, 1, 1), emptyCell(1, 2), cellWithValue(1, 3, 2)),
                List.of(emptyCell(2, 0), cellWithValue(2, 1, 4), emptyCell(2, 2), cellWithValue(2, 3, 3)),
                List.of(cellWithValue(3, 0, 2), emptyCell(3, 1), cellWithValue(3, 2, 1), emptyCell(3, 3))));

        Grid updatedGrid = strategy.addOneNumber(grid);

        assertEquals(2, updatedGrid.getCells().get(0).get(1).getValue().get());
    }
}