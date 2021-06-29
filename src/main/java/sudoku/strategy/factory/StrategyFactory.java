package sudoku.strategy.factory;

import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;
import sudoku.strategy.impl.ByPossibleValues;
import sudoku.strategy.impl.ByPossibleValues2;
import sudoku.strategy.impl.SquareStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StrategyFactory {
    public List<SolutionStrategy> createStrategiesFor(Grid grid) { //TODO test
        List<SolutionStrategy> strategies = new ArrayList<>();
        List<Integer> indexes = IntStream.range(0, grid.size()).boxed().collect(Collectors.toList());

        //TODO invece di creare una strategia per cella si potrebbe fare una strategia per tipologia (che cicla su tutte le celle applicando la stessa logica)
        strategies.add(new ByPossibleValues(new ByPossibleValues2()));
        addSquareStrategies(strategies, indexes);

        return strategies;
    }

    private void addSquareStrategies(List<SolutionStrategy> strategies, List<Integer> indexes) {
        for (Integer rowIndex : indexes) {
            for (Integer columnIndex : indexes) {
                strategies.add(new SquareStrategy(rowIndex, columnIndex));
            }
        }
    }
}
