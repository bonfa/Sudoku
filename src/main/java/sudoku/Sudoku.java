package sudoku;

import java.util.List;

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
        grid.get(0).get(0).setValue(1);
    }
}
