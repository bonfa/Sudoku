package sudoku;

import sudoku.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class GridExtractors {
    private static final Function<List<List<Cell>>, List<Zone>> cellsToZone = cells -> cells.stream().map(Zone::new).collect(toList());
    private static final Function<Grid, List<List<Cell>>> cellsExtractor = grid -> grid.zones;
    private static final UnaryOperator<List<Zone>> rowsToColumns = zones ->
            IntStream.range(0, zones.size())
                     .mapToObj(i -> new Zone(zones.stream().map(l -> l.cells.get(i)).collect(toList())))
                     .collect(toList());
    private static UnaryOperator<List<List<Cell>>> rowsToSquares = cells -> {
        List<List<Cell>> squares = new ArrayList<>();
        for (int i = 0; i < cells.size(); i++) {
            squares.add(new ArrayList<>());
        }

        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                int n = SquareNumberMap.getSquareNumber(cells, i, j);

                squares.get(n).add(cells.get(i).get(j));
            }
        }
        return squares;
    };


    public static Function<Grid, Integer> sizeExtractor = grid -> grid.getCells().size();

    public static Function<Grid, List<Zone>> rowsExtractor = cellsExtractor.andThen(cellsToZone);
    public static Function<Grid, List<Zone>> columnsExtractor = grid -> rowsExtractor.andThen(rowsToColumns).apply(grid);
    public static Function<Grid, List<Zone>> getSquares = cellsExtractor.andThen(rowsToSquares).andThen(cellsToZone);


    public static BiFunction<Grid, Position, Cell> cellExtractor = (grid, position) -> {
        List<Zone> zones = rowsExtractor.apply(grid);
        return zones.get(position.rowIndex).cells.get(position.columnIndex);
    };

    public static BiFunction<Grid, Position, Zone> rowExtractor = (grid, position) -> rowsExtractor.apply(grid).get(position.rowIndex);
    public static BiFunction<Grid, Position, Zone> columnExtractor = (grid, position) -> columnsExtractor.apply(grid).get(position.columnIndex);
    public static BiFunction<Grid, Position, Zone> squareExtractor = (grid, position) -> getSquares.apply(grid).get(SquareNumberMap.getSquareNumber(grid.getCells(), position.rowIndex, position.columnIndex));
}
