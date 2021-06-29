package sudoku.strategy.factory;

import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;
import sudoku.strategy.impl.SingleCellStrategy;
import sudoku.strategy.impl.SquareStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SingleCellsStrategyFactory {
    public List<SolutionStrategy> createStrategiesFor(Grid grid) { //TODO test
        List<SolutionStrategy> strategies = new ArrayList<>();

        List<Integer> indexes = IntStream.range(0, grid.size()).boxed().collect(Collectors.toList());
        for (Integer rowIndex : indexes) {
            for (Integer columnIndex : indexes) {
                strategies.add(new SingleCellStrategy(rowIndex, columnIndex));
            }
        }

        for (Integer rowIndex : indexes) {
            for (Integer columnIndex : indexes) {
                strategies.add(new SquareStrategy(rowIndex, columnIndex));
            }
        }

        return strategies;
    }
}
