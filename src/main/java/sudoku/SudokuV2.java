package sudoku;

import java.util.List;
import java.util.stream.Collectors;

public class SudokuV2 {
    private final List<Row> rows;

    public SudokuV2(List<Row> rows) {
        this.rows = rows;
    }

    public List<List<CellV2>> getCells() {
        return List.copyOf(rows.stream()
                               .map(Row::getCells)
                               .collect(Collectors.toList()));
    }

    public boolean isSolved() {
        return rows.stream().allMatch(Row::isSolved);
    }

    public void findOneNumber() {
        for (Row row : rows) {
            if (row.findOneNumber())
                return;
        }
    }
}
