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

public class GridExtractors {
    private static final Function<List<List<Cell>>, List<Zone>> cellsToZone = cells -> cells.stream().map(Zone::new).collect(toList());
    private static final Function<Grid, List<List<Cell>>> cellsExtractor = grid -> grid.zones;

    //TODO test
    private static final UnaryOperator<List<List<Cell>>> rowsToColumns = cells ->
            IntStream.range(0, cells.size())
                     .mapToObj(i -> cells.stream().map(l -> l.get(i)).collect(toList()))
                     .collect(toList());

    //TODO improve
    private static final UnaryOperator<List<List<Cell>>> rowsToSquares = cells -> {
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


    public static final Function<Grid, Integer> sizeExtractor = grid -> grid.getCells().size();

    public static final Function<Grid, List<Zone>> rowsExtractor = cellsExtractor.andThen(identity()).andThen(cellsToZone);
    public static final Function<Grid, List<Zone>> columnsExtractor = cellsExtractor.andThen(rowsToColumns).andThen(cellsToZone);
    public static final Function<Grid, List<Zone>> getSquares = cellsExtractor.andThen(rowsToSquares).andThen(cellsToZone);

    public static final BiFunction<Grid, Position, Zone> rowExtractor = (grid, position) -> rowsExtractor.apply(grid).get(position.rowIndex);
    public static final BiFunction<Grid, Position, Zone> columnExtractor = (grid, position) -> columnsExtractor.apply(grid).get(position.columnIndex);
    public static final BiFunction<Grid, Position, Zone> squareExtractor = (grid, position) -> getSquares.apply(grid).get(SquareNumberMap.getSquareNumber(grid.getCells(), position.rowIndex, position.columnIndex));

    //TODO i don't like the fact that position is passed completely in rowExtractor and, then, rowExtractor is using only the rowIndex
    public static final BiFunction<Grid, Position, Cell> cellExtractor = (grid, position) -> rowExtractor.apply(grid, position).cells.get(position.columnIndex);
}
