package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.strategy.SolutionStrategy;
import sudoku.strategy.factory.StrategyFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sudoku.Cell.cellWithValue;
import static sudoku.Cell.emptyCell;

class SudokuIT {

    @Test
    void solve_4x4() {
        Grid iteration_0 = new Grid(List.of(
                List.of(cellWithValue(0, 0, 3), emptyCell(0, 1), cellWithValue(0, 2, 4), emptyCell(0, 3)),
                List.of(emptyCell(1, 0), cellWithValue(1, 1, 1), emptyCell(1, 2), cellWithValue(1, 3, 2)),
                List.of(emptyCell(2, 0), cellWithValue(2, 1, 4), emptyCell(2, 2), cellWithValue(2, 3, 3)),
                List.of(cellWithValue(3, 0, 2), emptyCell(3, 1), cellWithValue(3, 2, 1), emptyCell(3, 3))));

        List<SolutionStrategy> allStrategies = new StrategyFactory().createStrategiesFor(iteration_0);

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

        assertCellsContainsValues(iteration_0.getSquares().get(0), List.of(3, 2, 4, 1));
        assertCellsContainsValues(iteration_0.getSquares().get(1), List.of(4, 1, 3, 2));
        assertCellsContainsValues(iteration_0.getSquares().get(2), List.of(1, 4, 2, 3));
        assertCellsContainsValues(iteration_0.getSquares().get(3), List.of(2, 3, 1, 4));
    }

    @Test
    void solve_6x6() {
        Grid iteration_0 = new Grid(List.of(
                List.of(emptyCell(0, 0), cellWithValue(0, 1, 2), emptyCell(0, 2), cellWithValue(0, 3, 1), emptyCell(0, 4), emptyCell(0, 5)),
                List.of(emptyCell(1, 0), emptyCell(1, 1), emptyCell(1, 2), emptyCell(1, 3), cellWithValue(1, 4, 3), emptyCell(1, 5)),
                List.of(cellWithValue(2, 0, 6), emptyCell(2, 1), emptyCell(2, 2), emptyCell(2, 3), emptyCell(2, 4), cellWithValue(2, 5, 4)),
                List.of(cellWithValue(3, 0, 3), emptyCell(3, 1), emptyCell(3, 2), emptyCell(3, 3), emptyCell(3, 4), cellWithValue(3, 5, 5)),
                List.of(emptyCell(4, 0), cellWithValue(4, 1, 3), emptyCell(4, 2), emptyCell(4, 3), emptyCell(4, 4), emptyCell(4, 5)),
                List.of(emptyCell(5, 0), emptyCell(5, 1), cellWithValue(5, 2, 1), emptyCell(5, 3), cellWithValue(5, 4, 2), emptyCell(5, 5))));

        List<SolutionStrategy> allStrategies = new StrategyFactory().createStrategiesFor(iteration_0);

        Sudoku sudoku = new Sudoku(allStrategies);

        printGrid(iteration_0);
        Grid iteration = iteration_0;
        long numberOfFreeCells = iteration.getCells()
                                         .stream()
                                         .flatMap(c -> c.stream())
                                          .filter(c -> c.getValue().isEmpty())
                                         .count();

        for (int i = 0; i < numberOfFreeCells; i++) {
            iteration = sudoku.addOneNumber(iteration);
            printGrid(iteration);
        }
    }

    private void printGrid(Grid grid) {
        List<Cells> rows = grid.getRows();
        for (int i = 0; i < rows.size(); i++) {
            Cells row = rows.get(i);
            List<Cell> cells = row.getCells();
            for (int j = 0; j < cells.size(); j++) {
                System.out.print(cells.get(j).getValue().map(v -> String.format("%02d\t", v)).orElse("--\t"));
            }
            System.out.print("\n");
        }

        System.out.println("\n\n\n");
    }

    private void assertCellsContainsValues(Cells first, List<Integer> values) {
        List<Integer> cellValues = first.getCells()
                                                  .stream()
                                                  .map(cell -> cell.getValue().orElse(null))
                                                  .collect(Collectors.toList());

        assertEquals(cellValues, values);
    }
}

/**
 --	02	03	01	--	06
 01	--	--	--	03	02
 06	05	02	03	01	04
 03	01	04	02	06	05
 02	03	--	--	--	01
 --	--	01	--	02	03
 */