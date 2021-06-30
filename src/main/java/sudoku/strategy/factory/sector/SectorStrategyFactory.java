package sudoku.strategy.factory.sector;

import sudoku.Grid;
import sudoku.Zone;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.sector.SectorWithOneEmptyCellSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SectorStrategyFactory {
    private final Function<Grid, List<Zone>> rowsExtractor = Grid::getRows;
    private final Function<Grid, List<Zone>> columnsExtractor = Grid::getColumns;
    private final Function<Grid, List<Zone>> squaresExtractor = Grid::getSquares;
    private final SectorWithOneEmptyCellSolution sectorWithOneEmptyCellSolution = new SectorWithOneEmptyCellSolution();

    public List<Function<Grid, Optional<SolutionStep>>> createStrategies() {
        List<Function<Grid, Optional<SolutionStep>>> strategies = new ArrayList<>();

        strategies.add(rowsExtractor.andThen(sectorWithOneEmptyCellSolution));
        strategies.add(columnsExtractor.andThen(sectorWithOneEmptyCellSolution));
        strategies.add(squaresExtractor.andThen(sectorWithOneEmptyCellSolution));

        return strategies;
    }

}