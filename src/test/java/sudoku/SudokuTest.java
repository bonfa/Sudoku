package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.strategy.SolutionStrategy;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SudokuTest {

    private static final Grid A_GRID = new Grid(emptyList());
    private static final Grid ANOTHER_GRID = new Grid(emptyList());

    private final SolutionStrategy strategy_1 = mock(SolutionStrategy.class);
    private final SolutionStrategy strategy_2 = mock(SolutionStrategy.class);

    private final Sudoku sudoku = new Sudoku(List.of(strategy_1, strategy_2));

    @Test
    void canApplyFirstStrategy() {
        when(strategy_1.canAddOneNumber(A_GRID)).thenReturn(true);
        when(strategy_1.addOneNumber(A_GRID)).thenReturn(ANOTHER_GRID);

        Grid grid = sudoku.addOneNumber(A_GRID);

        assertEquals(ANOTHER_GRID, grid);
    }

    @Test
    void canApplySecondStrategy() {
        when(strategy_1.canAddOneNumber(A_GRID)).thenReturn(false);
        when(strategy_2.canAddOneNumber(A_GRID)).thenReturn(true);
        when(strategy_2.addOneNumber(A_GRID)).thenReturn(ANOTHER_GRID);

        Grid grid = sudoku.addOneNumber(A_GRID);

        assertEquals(ANOTHER_GRID, grid);
    }

    @Test
    void cannotApplyAnyStrategy() {
        when(strategy_1.canAddOneNumber(A_GRID)).thenReturn(false);
        when(strategy_2.canAddOneNumber(A_GRID)).thenReturn(false);

        Grid grid = sudoku.addOneNumber(A_GRID);

        assertEquals(A_GRID, grid);
    }
}