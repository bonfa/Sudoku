package sudoku.strategy.impl;

import org.junit.jupiter.api.Test;
import sudoku.Cell;
import sudoku.Grid;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class CellsStrategyContract {

    protected abstract CellsStrategy aStrategy();

    @Test
    void canAddOneNumber() {
        Grid grid = new Grid(List.of(List.of(Cell.emptyCell(0, 0))));

        assertTrue(aStrategy().canAddOneNumber(grid));
    }

    @Test
    void canNotAddOneNumber() {
        Grid grid = new Grid(List.of(List.of(Cell.cellWithValue(0, 0, 1))));

        assertFalse(aStrategy().canAddOneNumber(grid));
    }

    @Test
    void addOneNumber() {
        Grid grid = new Grid(List.of(List.of(Cell.emptyCell(0, 0))));

        Grid newGrid = aStrategy().addOneNumber(grid);

        assertEquals(1, newGrid.getCells().get(0).get(0).getValue().get());
    }
}
