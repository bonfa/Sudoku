package sudoku.strategy.impl;

//TODO improve this one
public class SolutionStep {
    public final Integer rowIndex;
    public final Integer columnIndex;
    public final Integer value;

    public SolutionStep(Integer rowIndex, Integer columnIndex, Integer value) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.value = value;
    }
}
