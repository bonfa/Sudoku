package sudoku.strategy.impl;

import sudoku.Grid;
import sudoku.strategy.SolutionStrategy;

import java.util.Optional;
import java.util.Set;

public class SingleCellStrategy implements SolutionStrategy {
    private final Integer rowIndex;
    private final Integer columnIndex;

    public SingleCellStrategy(Integer rowIndex, Integer columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    @Override
    public boolean canAddOneNumber(Grid grid) {
        return getFreeValuesForCell(grid).isPresent();
    }

    @Override
    public Grid addOneNumber(Grid grid) {
        Integer value = getFreeValuesForCell(grid).get();

        grid.getRows().get(rowIndex).getCells().get(columnIndex).setValue(value);

        return grid;
    }

    private Optional<Integer> getFreeValuesForCell(Grid grid) {
        Grid.PossibleValues possibleValuesFor = grid.getPossibleValuesFor(grid.getCells().get(rowIndex).get(columnIndex));

        Set<Integer> possibleValues = possibleValuesFor.getPossibleValues();

        if (possibleValues.size() == 1)
            return possibleValues.stream().findFirst();

        return Optional.empty();
    }
}
