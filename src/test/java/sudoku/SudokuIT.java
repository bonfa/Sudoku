package sudoku;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import sudoku.strategy.SolutionStrategy;
import sudoku.strategy.factory.StrategyFactory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sudoku.strategy.TestUtilities.gridWith;

class SudokuIT {

    @Test
    void solve_4x4() {
        Grid iteration_0 = gridWith(List.of("3", "-", "4", "-"),
                                    List.of("-", "1", "-", "2"),
                                    List.of("-", "4", "-", "3"),
                                    List.of("2", "-", "1", "-"));

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
    @Disabled("need to improve the algorithm to solve this one")
    void solve_6x6() {
        Grid iteration_0 = gridWith(List.of("-", "2", "-", "1", "-", "-"),
                                    List.of("-", "-", "-", "-", "3", "-"),
                                    List.of("6", "-", "-", "-", "-", "4"),
                                    List.of("3", "-", "-", "-", "-", "5"),
                                    List.of("-", "3", "-", "-", "-", "-"),
                                    List.of("-", "-", "1", "-", "2", "-"));

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

    @Test
    void solve_9x9() {
        Grid iteration_0 = gridWith(List.of("-", "3", "-", "-", "1", "-", "-", "6", "-"),
                                    List.of("7", "5", "-", "-", "3", "-", "-", "4", "8"),
                                    List.of("-", "-", "6", "9", "8", "4", "3", "-", "-"),
                                    List.of("-", "-", "3", "-", "-", "-", "8", "-", "-"),
                                    List.of("9", "1", "2", "-", "-", "-", "6", "7", "4"),
                                    List.of("-", "-", "4", "-", "-", "-", "5", "-", "-"),
                                    List.of("-", "-", "1", "6", "7", "5", "2", "-", "-"),
                                    List.of("6", "8", "-", "-", "9", "-", "-", "1", "5"),
                                    List.of("-", "9", "-", "-", "4", "-", "-", "3", "-"));

        List<SolutionStrategy> allStrategies = new StrategyFactory().createStrategiesFor(iteration_0);

        Sudoku sudoku = new Sudoku(allStrategies);

        Grid iteration = iteration_0;
        long numberOfFreeCells = iteration.getCells()
                                          .stream()
                                          .flatMap(Collection::stream)
                                          .filter(c -> c.getValue().isEmpty())
                                          .count();

        for (int i = 0; i < numberOfFreeCells; i++) {
            iteration = sudoku.addOneNumber(iteration);
        }

        assertGridEquals(iteration, gridWith(List.of("4", "3", "8", "5", "1", "7", "9", "6", "2"),
                                             List.of("7", "5", "9", "2", "3", "6", "1", "4", "8"),
                                             List.of("1", "2", "6", "9", "8", "4", "3", "5", "7"),
                                             List.of("5", "7", "3", "4", "6", "9", "8", "2", "1"),
                                             List.of("9", "1", "2", "8", "5", "3", "6", "7", "4"),
                                             List.of("8", "6", "4", "7", "2", "1", "5", "9", "3"),
                                             List.of("3", "4", "1", "6", "7", "5", "2", "8", "9"),
                                             List.of("6", "8", "7", "3", "9", "2", "4", "1", "5"),
                                             List.of("2", "9", "5", "1", "4", "8", "7", "3", "6")));
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

    private void assertGridEquals(Grid first, Grid second) {
        assertEquals(first.getDimensions(), second.getDimensions());
        assertCellsEquals(first.getCells(), second.getCells());
    }

    private void assertCellsEquals(List<List<Cell>> first, List<List<Cell>> second) {
        first.stream().forEach(row -> row.stream()
                                         .forEach(cell -> assertCellEquals(cell, second.get(cell.getRowIndex()).get(cell.getColumnIndex()))));
    }

    private void assertCellEquals(Cell first, Cell second) {
        assertEquals(first.getRowIndex(), second.getRowIndex());
        assertEquals(first.getColumnIndex(), second.getColumnIndex());
        assertEquals(first.getValue(), second.getValue());
    }

    private void assertCellsContainsValues(Cells first, List<Integer> values) {
        List<Integer> cellValues = first.getCells()
                                        .stream()
                                        .map(cell -> cell.getValue().orElse(null))
                                        .collect(Collectors.toList());

        assertEquals(cellValues, values);
    }
}