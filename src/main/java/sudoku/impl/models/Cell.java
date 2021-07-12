package sudoku.impl.models;

import java.util.Optional;

public class Cell {
    private final Position position;
    private Integer value;

    private Cell(Position position, Integer value) {
        this.position = position;
        this.value = value;
    }

    public static Cell emptyCell(Position position) {
        return new Cell(position, null);
    }

    public static Cell cellWithValue(int value, Position position) {
        return new Cell(position, value);
    }

    public Position getPosition() {
        return position;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Optional<Integer> getValue() {
        return Optional.ofNullable(value);
    }

}
