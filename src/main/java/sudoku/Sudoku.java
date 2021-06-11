package sudoku;

import java.util.List;

public class Sudoku {
    private final Grid grid;

    public Sudoku(Grid grid) {
        this.grid = grid;
    }

    public List<List<Cell>> getCells() {
        return grid.getCells();
    }

    public boolean isSolved() {
        return grid.getCells().stream().allMatch(cols -> cols.stream().allMatch(cell -> cell.getValue().isPresent()));
    }

    public void setOneNumber() {
        if (isSolved()) return;

        grid.getRows()
            .stream()
            .filter(Cells::canSolve)
            .findFirst()
            .ifPresent(Cells::solve);
    }
}
