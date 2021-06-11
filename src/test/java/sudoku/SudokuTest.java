package sudoku;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.*;

class SudokuTest {

    private static final Grid A_GRID = new Grid(emptyList());

    private final SolutionStrategy strategy_1 = mock(SolutionStrategy.class);
    private final SolutionStrategy strategy_2 = mock(SolutionStrategy.class);

    private final Sudoku sudoku = new Sudoku(List.of(strategy_1, strategy_2));

    @Test
    void canApplyFirstStrategy() {
        when(strategy_1.canSolve(A_GRID)).thenReturn(true);

        sudoku.setOneNumber(A_GRID);

        verify(strategy_1).execute(A_GRID);
    }

    @Test
    void canApplySecondStrategy() {
        when(strategy_1.canSolve(A_GRID)).thenReturn(false);
        when(strategy_2.canSolve(A_GRID)).thenReturn(true);

        sudoku.setOneNumber(A_GRID);

        verify(strategy_1, never()).execute(A_GRID);
        verify(strategy_2).execute(A_GRID);
    }
}