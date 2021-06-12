package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.strategy.SolutionStrategy;
import sudoku.strategy.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sudoku.Cell.cellWithValue;
import static sudoku.Cell.emptyCell;

class SudokuIT {

    @Test
    void works() {
        Grid iteration_0 = new Grid(List.of(
                List.of(cellWithValue(0, 0, 3), emptyCell(0, 1), cellWithValue(0, 2, 4), emptyCell(0, 3)),
                List.of(emptyCell(1, 0), cellWithValue(1, 1, 1), emptyCell(1, 2), cellWithValue(1, 3, 2)),
                List.of(emptyCell(2, 0), cellWithValue(2, 1, 4), emptyCell(2, 2), cellWithValue(2, 3, 3)),
                List.of(cellWithValue(3, 0, 2), emptyCell(3, 1), cellWithValue(3, 2, 1), emptyCell(3, 3))));

        List<SolutionStrategy> allStrategies = new SingleCellsStrategyFactory().createStrategiesFor(iteration_0);

        Sudoku sudoku = new Sudoku(allStrategies);

        Grid iteration_1 = sudoku.addOneNumber(iteration_0);
        assertEquals(2, iteration_1.getCells().get(0).get(1).getValue().get());

        Grid iteration_2 = sudoku.addOneNumber(iteration_1);
        assertEquals(1, iteration_2.getCells().get(0).get(3).getValue().get());

        Grid iteration_3 = sudoku.addOneNumber(iteration_2);
        assertEquals(4, iteration_3.getCells().get(1).get(0).getValue().get());

        Grid iteration_4 = sudoku.addOneNumber(iteration_3);
        assertEquals(3, iteration_4.getCells().get(1).get(2).getValue().get());

        Grid iteration_5 = sudoku.addOneNumber(iteration_4);
        assertEquals(1, iteration_5.getCells().get(2).get(0).getValue().get());

        Grid iteration_6 = sudoku.addOneNumber(iteration_5);
        assertEquals(2, iteration_6.getCells().get(2).get(2).getValue().get());

        Grid iteration_7 = sudoku.addOneNumber(iteration_6);
        assertEquals(3, iteration_7.getCells().get(3).get(1).getValue().get());

        Grid iteration_8 = sudoku.addOneNumber(iteration_7);
        assertEquals(4, iteration_8.getCells().get(3).get(3).getValue().get());

        assertCellContainsValues(iteration_0.getSquares().get(0), Set.of(3, 2, 4, 1));
        assertCellContainsValues(iteration_0.getSquares().get(1), Set.of(4, 1, 3, 2));
        assertCellContainsValues(iteration_0.getSquares().get(2), Set.of(1, 4, 2, 3));
        assertCellContainsValues(iteration_0.getSquares().get(3), Set.of(2, 3, 1, 4));
    }

    private void assertCellContainsValues(Cells cells, Set<Integer> values) {
        var expected = cells.getCells().stream().flatMap(c -> c.getValue().stream()).collect(Collectors.toSet());

        assertEquals(expected, values);
    }
}