package deprecated;

import java.util.List;
import java.util.stream.Collectors;

@Deprecated
public class SudokuV2 {
    private final List<Cells> rows;
    private final List<Cells> columns;
    private final List<Cells> squares;

    public SudokuV2(List<Cells> rows, List<Cells> columns, List<Cells> squares) {
        this.rows = rows;
        this.columns = columns;
        this.squares = squares;
    }

    public List<Cells> getSquares() {
        return squares;
    }

    public List<Cells> getColumns() {
        return columns;
    }

    public List<List<CellV2>> getCells() {
        return List.copyOf(rows.stream()
                               .map(Cells::getCells)
                               .collect(Collectors.toList()));
    }

    public boolean isSolved() {
        return rows.stream().allMatch(Cells::isSolved);
    }

    public void setOneNumber() {
        for (Cells row : rows) {
            if (row.setOneNumber())
                return;
        }

        for (Cells column : columns) {
            if (column.setOneNumber())
                return;
        }
    }
}
