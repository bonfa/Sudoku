package sudoku;

import sudoku.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static sudoku.SquareNumberMap.squareMapping;

public class GridExtractors {
    private static final Function<List<List<Cell>>, List<Zone>> cellsToZone = cells -> cells.stream().map(Zone::new).collect(toList());
    private static final Function<Grid, List<List<Cell>>> cellsExtractor = grid -> grid.zones;
    private static final Function<Zone, List<Cell>> zoneToCells = zone -> zone.cells;
    private static final Function<List<Zone>, List<List<Cell>>> zonesToCells = zones -> zones.stream().map(zoneToCells).collect(toList());
    private static final Function<List<List<Cell>>, Integer> cellsSizeExtractor = List::size;

    //TODO test
    private static final UnaryOperator<List<List<Cell>>> rowsToColumns = cells ->
            IntStream.range(0, cells.size())
                     .mapToObj(i -> cells.stream().map(l -> l.get(i)).collect(toList()))
                     .collect(toList());

    //TODO improve
    private static final UnaryOperator<List<List<Cell>>> rowsToSquares = cells -> {
        List<List<Cell>> squares = IntStream.range(0, cells.size())
                                            .mapToObj(i -> new ArrayList<Cell>())
                                            .collect(toList());

        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                int n = squareMapping.apply(cellsSizeExtractor.apply(cells), new Position(i, j));

                squares.get(n).add(cells.get(i).get(j));
            }
        }
        return squares;
    };


    public static final Function<Grid, Integer> sizeExtractor = cellsExtractor.andThen(cellsSizeExtractor);

    public static final Function<Grid, List<Zone>> rowsExtractor = cellsExtractor.andThen(identity()).andThen(cellsToZone);
    public static final Function<Grid, List<Zone>> columnsExtractor = cellsExtractor.andThen(rowsToColumns).andThen(cellsToZone);
    public static final Function<Grid, List<Zone>> squaresExtractor = cellsExtractor.andThen(rowsToSquares).andThen(cellsToZone);

    public static final BiFunction<Grid, Position, Zone> rowExtractor = (grid, position) -> rowsExtractor.apply(grid).get(position.rowIndex);
    public static final BiFunction<Grid, Position, Zone> columnExtractor = (grid, position) -> columnsExtractor.apply(grid).get(position.columnIndex);
    public static final BiFunction<Grid, Position, Zone> squareExtractor = (grid, position) -> squaresExtractor.apply(grid).get(squareMapping.apply(sizeExtractor.apply(grid), position));

    //TODO i don't like the fact that position is passed completely in rowExtractor and, then, rowExtractor is using only the rowIndex
    public static final BiFunction<Grid, Position, Cell> cellExtractor = (grid, position) -> rowExtractor.apply(grid, position).cells.get(position.columnIndex);
}
