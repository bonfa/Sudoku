package sudoku;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sudoku {
    private final List<List<Cell>> grid;

    public Sudoku(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public List<List<Cell>> getCells() {
        return grid;
    }

    public boolean isSolved() {
        return grid.stream().allMatch(cols -> cols.stream().allMatch(cell -> cell.getValue().isPresent()));
    }

    public void setOneNumber() {
        if (isSolved()) return;

        for (List<Cell> row : grid) {
            if (solveByRow(row)) break;
        }
    }

    private boolean solveByRow(List<Cell> cells) {
        List<Cell> emptyCells = cells.stream().filter(cell -> cell.getValue().isEmpty()).collect(Collectors.toList());

        if (emptyCells.size() != 1) return false;

        Set<Integer> allValues = IntStream.rangeClosed(1, cells.size()).boxed().collect(Collectors.toSet());
        Set<Integer> valuesAlreadyPresent = cells.stream().flatMap(c -> c.getValue().stream()).collect(Collectors.toSet());
        Set<Integer> difference = difference(allValues, valuesAlreadyPresent);

        emptyCells.get(0).setValue(difference.stream().findFirst().get());

        return true;
    }

    private static Set<Integer> difference(Set<Integer> first, Set<Integer> second) {
        Set<Integer> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }
}
