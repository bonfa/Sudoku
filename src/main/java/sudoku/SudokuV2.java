package sudoku;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuV2 {
    private final List<Row> rows;
    private final List<Column> columns;

    public SudokuV2(List<Row> rows) {
        this.rows = rows;
        this.columns = toColumn(rows);
    }

    private List<Column> toColumn(List<Row> rows) {
        return IntStream.range(0, rows.get(0).size())
                        .mapToObj(i -> new Column(rows.stream().map(l -> l.getCells().get(i)).collect(Collectors.toList())))
                        .collect(Collectors.toList());
    }

    public List<List<CellV2>> getCells() {
        return List.copyOf(rows.stream()
                               .map(Row::getCells)
                               .collect(Collectors.toList()));
    }

    public boolean isSolved() {
        return rows.stream().allMatch(Row::isSolved);
    }

    public void setOneNumber() {
        for (Row row : rows) {
            if (row.setOneNumber())
                return;
        }

        for (Column column : columns) {
            if (column.setOneNumber())
                return;
        }
    }
}
