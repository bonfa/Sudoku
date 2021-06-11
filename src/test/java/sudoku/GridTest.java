package sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sudoku.Cell.*;

class GridTest {

    private static final Cell CELL_0_0 = cellWithValue(0, 0, 1);
    private static final Cell CELL_0_1 = cellWithValue(0, 1, 2);
    private static final Cell CELL_0_2 = cellWithValue(0, 2, 3);
    private static final Cell CELL_1_0 = cellWithValue(1, 0, 4);
    private static final Cell CELL_1_1 = cellWithValue(1, 1, 5);
    private static final Cell CELL_1_2 = cellWithValue(1, 2, 6);
    private static final Cell CELL_2_0 = cellWithValue(2, 0, 7);
    private static final Cell CELL_2_1 = cellWithValue(2, 1, 8);
    private static final Cell CELL_2_2 = cellWithValue(2, 2, 9);

    @Test
    void getRows() {
        Grid grid = new Grid(List.of(List.of(CELL_0_0, CELL_0_1, CELL_0_2),
                                     List.of(CELL_1_0, CELL_1_1, CELL_1_2),
                                     List.of(CELL_2_0, CELL_2_1, CELL_2_2)));

        List<Cells> cells = grid.getRows();

        assertEquals(3, cells.size());
        assertEquals(List.of(CELL_0_0, CELL_0_1, CELL_0_2), cells.get(0).getCells());
        assertEquals(List.of(CELL_1_0, CELL_1_1, CELL_1_2), cells.get(1).getCells());
        assertEquals(List.of(CELL_2_0, CELL_2_1, CELL_2_2), cells.get(2).getCells());
    }

    @Test
    void getColumns() {
        Grid grid = new Grid(List.of(List.of(CELL_0_0, CELL_0_1, CELL_0_2),
                                     List.of(CELL_1_0, CELL_1_1, CELL_1_2),
                                     List.of(CELL_2_0, CELL_2_1, CELL_2_2)));

        List<Cells> columns = grid.getColumns();

        assertEquals(3, columns.size());

        assertEquals(List.of(CELL_0_0, CELL_1_0, CELL_2_0), columns.get(0).getCells());
        assertEquals(List.of(CELL_0_1, CELL_1_1, CELL_2_1), columns.get(1).getCells());
        assertEquals(List.of(CELL_0_2, CELL_1_2, CELL_2_2), columns.get(2).getCells());
    }

}