package sudoku;

import java.util.List;

public class Sudoku {
    private final List<SolutionStrategy> strategies;

    public Sudoku(List<SolutionStrategy> strategies) {
        this.strategies = strategies;
    }

    public Grid addOneNumber(Grid grid) {
        return strategies.stream()
                         .filter(s -> s.canAddOneNumber(grid))
                         .findFirst()
                         .map(s -> s.addOneNumber(grid))
                         .orElse(grid);
    }
}
