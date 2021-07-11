package sudoku.strategy;

import sudoku.models.Cell;
import sudoku.models.Grid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtilities {
    public static Grid gridWith(List<String>... rows) {
        List<List<Cell>> collect = IntStream.range(0, rows.length)
                                            .mapToObj(i -> parseRow(rows[i], i))
                                            .collect(Collectors.toList());

        return new Grid(collect);
    }

    private static List<Cell> parseRow(List<String> zone, int rowIndex) {
        return IntStream.range(0, zone.size())
                        .mapToObj(j -> parseCell(zone.get(j), rowIndex, j))
                        .collect(Collectors.toList());
    }

    private static Cell parseCell(String rawValue, int rowIndex, int columnIndex) {
        if ("-".equals(rawValue)) {
            return Cell.emptyCell(new Grid.Position(rowIndex, columnIndex));
        } else {
            return Cell.cellWithValue(Integer.parseInt(rawValue), new Grid.Position(rowIndex, columnIndex));
        }
    }
}
