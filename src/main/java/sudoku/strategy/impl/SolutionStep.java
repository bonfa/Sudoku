package sudoku.strategy.impl;

import sudoku.Grid;

//TODO improve this one
public class SolutionStep {
    public final Grid.Position position;
    public final Integer value;

    public SolutionStep(Grid.Position position, Integer value) {
        this.position = position;
        this.value = value;
    }
}
