package sudoku;

public class RowStrategy implements SolutionStrategy {

    @Override
    public boolean canAddOneNumber(Grid grid) {
        return grid.getRows().stream().anyMatch(Cells::canSolve);
    }

    @Override
    public Grid addOneNumber(Grid grid) {
        grid.getRows().stream().filter(Cells::canSolve).findFirst().ifPresent(Cells::solve);
        return grid;
    }
}
