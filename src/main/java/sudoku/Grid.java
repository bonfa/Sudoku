package sudoku;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    private final List<List<Cell>> cells;

    public Grid(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public List<Cells> getRows() {
        return cells.stream()
                    .map(Cells::new)
                    .collect(Collectors.toList());
    }

    public List<Cells> getColumns() {
        return IntStream.range(0, getRows().size())
                        .mapToObj(i -> new Cells(getRows().stream().map(l -> l.getCells().get(i)).collect(Collectors.toList())))
                        .collect(Collectors.toList());
    }
}
