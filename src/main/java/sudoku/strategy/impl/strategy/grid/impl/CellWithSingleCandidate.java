package sudoku.strategy.impl.strategy.grid.impl;

import sudoku.Grid;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.CellStrategy;

import java.util.Optional;
import java.util.Set;

public class CellWithSingleCandidate implements CellStrategy {

    @Override
    public Optional<SolutionStep> findSolutionStepFor(Grid grid, Integer rowIndex, Integer columnIndex) {
        Set<Integer> candidates = grid.getCandidates(grid.getCells().get(rowIndex).get(columnIndex)).getValues();

        if (candidates.size() == 1)
            return candidates.stream().findFirst().map(value -> new SolutionStep(new Grid.Position(rowIndex, columnIndex), value));

        return Optional.empty();
    }
}
