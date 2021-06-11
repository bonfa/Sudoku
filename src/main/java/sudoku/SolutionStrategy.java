package sudoku;

public interface SolutionStrategy {
    boolean canAddOneNumber(Grid grid);
    Grid addOneNumber(Grid grid);
}
