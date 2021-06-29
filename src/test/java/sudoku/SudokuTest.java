package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.strategy.impl.SolutionStep;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static sudoku.Sudoku.*;

class SudokuTest {

    private static final Grid A_GRID = new Grid(emptyList());
    private static final Grid ANOTHER_GRID = new Grid(emptyList());
    private static final SolutionStep A_SOLUTION_STEP = new SolutionStep(0, 0, 1);

    private final Function<Grid, Optional<SolutionStep>> strategy_1 = mock(Function.class);
    private final Function<Grid, Optional<SolutionStep>> strategy_2 = mock(Function.class);
    private final SolutionStepApplier solutionStepApplier = mock(SolutionStepApplier.class);

    private final Sudoku sudoku = new Sudoku(List.of(strategy_1, strategy_2), solutionStepApplier);

    @Test
    void canApplyFirstStrategy() {
        when(strategy_1.apply(A_GRID)).thenReturn(Optional.of(A_SOLUTION_STEP));
        when(strategy_2.apply(A_GRID)).thenReturn(Optional.empty());
        when(solutionStepApplier.apply(A_GRID, A_SOLUTION_STEP)).thenReturn(ANOTHER_GRID);

        Grid grid = sudoku.apply(A_GRID);

        assertEquals(ANOTHER_GRID, grid);
    }

    @Test
    void canApplySecondStrategy() {
        when(strategy_1.apply(A_GRID)).thenReturn(Optional.empty());
        when(strategy_2.apply(A_GRID)).thenReturn(Optional.of(A_SOLUTION_STEP));
        when(solutionStepApplier.apply(A_GRID, A_SOLUTION_STEP)).thenReturn(ANOTHER_GRID);

        Grid grid = sudoku.apply(A_GRID);

        assertEquals(ANOTHER_GRID, grid);
    }

    @Test
    void cannotApplyAnyStrategy() {
        when(strategy_1.apply(A_GRID)).thenReturn(Optional.empty());
        when(strategy_2.apply(A_GRID)).thenReturn(Optional.empty());

        Grid grid = sudoku.apply(A_GRID);

        assertEquals(A_GRID, grid);
        verifyNoInteractions(solutionStepApplier);
    }
}