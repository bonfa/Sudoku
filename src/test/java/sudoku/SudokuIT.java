package sudoku;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import sudoku.impl.extractors.GridExtractors;
import sudoku.models.Cell;
import sudoku.models.Grid;

import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sudoku.impl.strategy.TestUtilities.gridWith;

class SudokuIT {
    private final UnaryOperator<Grid> sudoku = Sudoku.sudoku;

    @Test
    void solve_4x4() {
        Grid iteration_0 = gridWith(List.of("3", "-", "4", "-"),
                                    List.of("-", "1", "-", "2"),
                                    List.of("-", "4", "-", "3"),
                                    List.of("2", "-", "1", "-"));

        Grid iteration_1 = sudoku.apply(iteration_0);
        assertEquals(2, iteration_1.cells.get(0).get(1).getValue().get());

        Grid iteration_2 = sudoku.apply(iteration_1);
        assertEquals(1, iteration_2.cells.get(0).get(3).getValue().get());

        printGrid(iteration_2);

        Grid iteration_3 = sudoku.apply(iteration_2);

        Grid iteration_4 = sudoku.apply(iteration_3);

        Grid iteration_5 = sudoku.apply(iteration_4);

        Grid iteration_6 = sudoku.apply(iteration_5);

        Grid iteration_7 = sudoku.apply(iteration_6);

        Grid iteration_8 = sudoku.apply(iteration_7);

        var cells = iteration_8.cells;

        assertCellsContainsValues(cells.get(0), List.of(3, 2, 4, 1));
        assertCellsContainsValues(cells.get(1), List.of(4, 1, 3, 2));
        assertCellsContainsValues(cells.get(2), List.of(1, 4, 2, 3));
        assertCellsContainsValues(cells.get(3), List.of(2, 3, 1, 4));
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

        printGrid(iteration_0);
        Grid iteration = iteration_0;
        long numberOfFreeCells = iteration.cells
                                          .stream()
                                          .flatMap(c -> c.stream())
                                          .filter(c -> c.getValue().isEmpty())
                                          .count();

        for (int i = 0; i < numberOfFreeCells; i++) {
            iteration = sudoku.apply(iteration);
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

        Grid iteration = iteration_0;
        long numberOfFreeCells = iteration.cells
                                          .stream()
                                          .flatMap(Collection::stream)
                                          .filter(c -> c.getValue().isEmpty())
                                          .count();

        for (int i = 0; i < numberOfFreeCells; i++) {
            iteration = sudoku.apply(iteration);
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
        List<List<Cell>> rows = grid.cells;
        for (List<Cell> zone : rows) {
            for (Cell cell : zone) {
                System.out.print(cell.getValue().map(v -> String.format("%02d\t", v)).orElse("--\t"));
            }
            System.out.print("\n");
        }

        System.out.println("\n\n\n");
    }

    private void assertGridEquals(Grid first, Grid second) {
        assertEquals(GridExtractors.extractSize.apply(first), GridExtractors.extractSize.apply(second));
        assertCellsEquals(first.cells, second.cells);
    }

    private void assertCellsEquals(List<List<Cell>> first, List<List<Cell>> second) {
        first.stream().forEach(row -> row.stream()
                                         .forEach(cell -> assertCellEquals(cell, second.get(cell.getPosition().rowIndex).get(cell.getPosition().columnIndex))));
    }

    private void assertCellEquals(Cell first, Cell second) {
        assertEquals(first.getPosition().rowIndex, second.getPosition().rowIndex);
        assertEquals(first.getPosition().columnIndex, second.getPosition().columnIndex);
        assertEquals(first.getValue(), second.getValue());
    }

    private void assertCellsContainsValues(List<Cell> actual, List<Integer> expected) {
        List<Integer> cellValues = actual
                .stream()
                .map(cell -> cell.getValue().orElse(null))
                .collect(Collectors.toList());

        assertEquals(cellValues, expected);
    }
}