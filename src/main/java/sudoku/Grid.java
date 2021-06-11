package sudoku;

import java.util.List;
import java.util.stream.Collectors;

public class Grid {
    private final List<List<Cell>> cells;

    public Grid(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public List<Row> getRows() {
        return cells.stream()
                    .map(Row::new)
                    .collect(Collectors.toList());
    }
}
