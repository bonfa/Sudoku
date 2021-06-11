package sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sudoku.Cell.*;

class GridTest {
    private static final Cell CELL_0_1 = cellWithValue(0, 0, 1);
    private static final Cell CELL_0_2 = cellWithValue(0, 1, 2);
    private static final Cell CELL_0_3 = cellWithValue(0, 2, 3);

    @Test
    void getRows() {
        Grid grid = new Grid(List.of(List.of(CELL_0_1, CELL_0_2, CELL_0_3)));

        List<Row> rows = grid.getRows();

        assertEquals(1, rows.size());
        assertEquals(CELL_0_1, rows.get(0).getCells().get(0));
        assertEquals(CELL_0_2, rows.get(0).getCells().get(1));
        assertEquals(CELL_0_3, rows.get(0).getCells().get(2));
    }
}