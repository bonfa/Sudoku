package sudoku;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuV2 {
    private final List<Cells> rows;
    private final List<Cells> columns;

    public SudokuV2(List<Cells> rows) {
        this.rows = rows;
        this.columns = toColumn(rows);
    }

    private List<Cells> toColumn(List<Cells> rows) {
        return IntStream.range(0, rows.get(0).size())
                        .mapToObj(i -> new Cells(rows.stream().map(l -> l.getCells().get(i)).collect(Collectors.toList())))
                        .collect(Collectors.toList());
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
