package sudoku;

import sudoku.strategy.impl.StepByStepGridStrategy;

import java.util.List;

public class Sudoku {
    private final List<StepByStepGridStrategy> strategies;

    public Sudoku(List<StepByStepGridStrategy> strategies) {
        this.strategies = strategies;
    }

    public Grid addOneNumber(Grid grid) {
        //todo for the moment, if no strategy can be applied, the same input grid is returned. Evaluate if it is necessary to change this behavior in the future
        return strategies.stream()
                         .filter(s -> s.canAddOneNumber(grid))
                         .findFirst()
                         .map(s -> s.addOneNumber(grid))
                         .orElse(grid);
    }
}
