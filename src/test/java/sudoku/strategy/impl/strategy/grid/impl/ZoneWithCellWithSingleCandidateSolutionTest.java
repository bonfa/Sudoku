package sudoku.strategy.impl.strategy.grid.impl;

import org.junit.jupiter.api.Test;
import sudoku.Grid;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.zone.ZoneWithOneEmptyCellSolution;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.strategy.TestUtilities.gridWith;

class ZoneWithCellWithSingleCandidateSolutionTest {

    private final ZoneWithACellWithSingleCandidate strategy = new ZoneWithACellWithSingleCandidate();

    @Test
    void solutionStepFound() {
        Grid grid = gridWith(List.of("-", "-", "-", "-", "1", "2", "3", "4", "-"),
                             List.of("-", "-", "-", "-", "-", "-", "-", "5", "-"),
                             List.of("-", "-", "-", "-", "-", "-", "-", "6", "-"),
                             List.of("-", "-", "-", "-", "-", "-", "-", "-", "7"),
                             List.of("-", "-", "-", "-", "-", "-", "-", "-", "8"),
                             List.of("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                             List.of("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                             List.of("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                             List.of("-", "-", "-", "-", "-", "-", "-", "-", "-"));

        Optional<SolutionStep> solutionStep = strategy.apply(grid.getRows());

        assertTrue(solutionStep.isPresent());
        assertEquals(9, solutionStep.get().value);
        assertEquals(0, solutionStep.get().position.getRowIndex());
        assertEquals(8, solutionStep.get().position.getColumnIndex());
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