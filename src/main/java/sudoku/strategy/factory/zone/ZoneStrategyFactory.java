package sudoku.strategy.factory.zone;

import sudoku.Grid;
import sudoku.Zone;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.zone.ZoneWithOneEmptyCellSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ZoneStrategyFactory {
    private final Function<Grid, List<Zone>> rowsExtractor = Grid::getRows;
    private final Function<Grid, List<Zone>> columnsExtractor = Grid::getColumns;
    private final Function<Grid, List<Zone>> squaresExtractor = Grid::getSquares;
    private final ZoneWithOneEmptyCellSolution zoneWithOneEmptyCellSolution = new ZoneWithOneEmptyCellSolution();

    public List<Function<Grid, Optional<SolutionStep>>> createStrategies() {
        List<Function<Grid, Optional<SolutionStep>>> strategies = new ArrayList<>();

        strategies.add(rowsExtractor.andThen(zoneWithOneEmptyCellSolution));
        strategies.add(columnsExtractor.andThen(zoneWithOneEmptyCellSolution));
        strategies.add(squaresExtractor.andThen(zoneWithOneEmptyCellSolution));

        return strategies;
    }

}
