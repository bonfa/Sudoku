package sudoku.strategy.impl.strategy.grid.impl;

import sudoku.Grid;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.CellStrategy;

import java.util.Optional;
import java.util.Set;

public class ByPossibleValues2 implements CellStrategy {

    @Override
    public Optional<SolutionStep> findSolutionStepFor(Grid grid, Integer rowIndex, Integer columnIndex) {
        Set<Integer> possibleValues = grid.getPossibleValuesFor(grid.getCells().get(rowIndex).get(columnIndex)).getPossibleValues();

        if (possibleValues.size() == 1)
            return possibleValues.stream().findFirst().map(value -> new SolutionStep(rowIndex, columnIndex, value));

        return Optional.empty();
    }
}
