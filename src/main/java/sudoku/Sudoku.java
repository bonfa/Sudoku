package sudoku;

import java.util.List;

public class Sudoku {
    private final List<SolutionStrategy> strategies;

    public Sudoku(List<SolutionStrategy> strategies) {
        this.strategies = strategies;
    }

    public void setOneNumber(Grid grid) {
        strategies.stream()
                  .filter(s -> s.canSolve(grid))
                  .findFirst()
                  .ifPresent(s -> s.execute(grid));
    }
}
