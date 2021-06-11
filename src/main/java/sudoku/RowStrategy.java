package sudoku;

public class RowStrategy implements SolutionStrategy {

    @Override
    public boolean canSolve(Grid grid) {
        return grid.getRows().stream().anyMatch(Cells::canSolve);
    }

    @Override
    public void execute(Grid grid) {
        grid.getRows().stream().filter(Cells::canSolve).findFirst().ifPresent(Cells::solve);
    }
}
