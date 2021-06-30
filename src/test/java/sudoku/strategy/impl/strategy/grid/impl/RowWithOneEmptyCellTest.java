package sudoku.strategy.impl.strategy.grid.impl;

import org.junit.jupiter.api.Test;
import sudoku.Grid;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.sector.SectorWithOneEmptyCellSolution;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.strategy.TestUtilities.gridWith;

class ZoneWithOneEmptyCellSolutionTest {

    private final SectorWithOneEmptyCellSolution strategy = new SectorWithOneEmptyCellSolution();

    @Test
    void solutionStepFound() {
        Grid grid = gridWith(List.of("-", "1", "2"),
                             List.of("-", "-", "-"),
                             List.of("-", "-", "-"));

        Optional<SolutionStep> solutionStep = strategy.apply(grid.getRows());

        assertTrue(solutionStep.isPresent());
        assertEquals(3, solutionStep.get().value);
        assertEquals(0, solutionStep.get().rowIndex);
        assertEquals(0, solutionStep.get().columnIndex);
    }

    @Test
    void solutionStepNotFound() {
        Grid grid = gridWith(List.of("-", "-", "2"),
                             List.of("-", "-", "-"),
                             List.of("-", "-", "-"));

        Optional<SolutionStep> solutionStep = strategy.apply(grid.getRows());

        assertFalse(solutionStep.isPresent());
    }
}