package sudoku;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ZoneExtractors {

    public static Function<Grid, List<Zone>> rowsExtractor = Grid::getRows;
    public static Function<Grid, List<Zone>> columnsExtractor = Grid::getColumns;

    public static BiFunction<Grid, Grid.Position, Zone> rowExtractor = (grid, position) -> rowsExtractor.apply(grid).get(position.getRowIndex());
    public static BiFunction<Grid, Grid.Position, Zone> columnExtractor = (grid, position) -> columnsExtractor.apply(grid).get(position.getColumnIndex());
    public static BiFunction<Grid, Grid.Position, Zone> squareExtractor = (grid, position) -> grid.squareBy(position);
}
