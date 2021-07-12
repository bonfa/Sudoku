package sudoku.impl.models;

//TODO improve this one
public class SolutionStep {
    public final Position position;
    public final Integer value;

    public SolutionStep(Position position, Integer value) {
        this.position = position;
        this.value = value;
    }
}
