package sudoku.impl.models;

import java.util.List;

public class Grid {
    public final List<List<Cell>> cells;

    //TODO check invariant: number of rows = number of columns
    //TODO check invariant: number of rows in {1, 4, 6, 8, 9}
    public Grid(List<List<Cell>> cells) {
        this.cells = List.copyOf(cells);
    }
}
