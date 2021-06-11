package sudoku;

public interface SolutionStrategy {
    boolean canSolve(Grid grid);
    void execute(Grid grid);
}
