package sudoku;

import java.util.Optional;

public class Cell {
    private final Grid.Position position;
    private Integer value;

    private Cell(Grid.Position position, Integer value) {
        this.position = position;
        this.value = value;
    }

    public static Cell emptyCell(Grid.Position position) {
        return new Cell(position, null);
    }

    public static Cell cellWithValue(int value, Grid.Position position) {
        return new Cell(position, value);
    }

    public Grid.Position getPosition() {
        return position;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Optional<Integer> getValue() {
        return Optional.ofNullable(value);
    }

}
