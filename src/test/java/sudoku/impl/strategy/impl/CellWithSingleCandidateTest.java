package sudoku.impl.strategy.impl;

import org.junit.jupiter.api.Test;
import sudoku.models.SolutionStep;
import sudoku.models.Grid;
import sudoku.models.Position;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static sudoku.impl.strategy.TestUtilities.*;
import static sudoku.impl.strategy.impl.CellWithSingleCandidate.getSolutionStep;

class CellWithSingleCandidateTest {

    @Test
    void singleCellMissingInRow() {
        Grid grid = gridWith(List.of("1", "2", "-", "4"),
                             List.of("-", "-", "-", "-"),
                             List.of("-", "-", "-", "-"),
                             List.of("-", "-", "-", "-"));

        Optional<SolutionStep> solutionStepFor = getSolutionStep.apply(grid, new Position(0, 2));

        assertTrue(solutionStepFor.isPresent());
        assertEquals(3, solutionStepFor.get().value);
    }

    @Test
    void singleCellMissingInColumn() {
        Grid grid = gridWith(List.of("1", "-", "-", "-"),
                             List.of("-", "-", "-", "-"),
                             List.of("3", "-", "-", "-"),
                             List.of("4", "-", "-", "-"));

        Optional<SolutionStep> solutionStepFor = getSolutionStep.apply(grid, new Position(1, 0));

        assertTrue(solutionStepFor.isPresent());
        assertEquals(2, solutionStepFor.get().value);
    }

    @Test
    void singleCellMissingInSquare() {
        Grid grid = gridWith(List.of("-", "2", "-", "-"),
                             List.of("3", "4", "-", "-"),
                             List.of("-", "-", "-", "-"),
                             List.of("-", "-", "-", "-"));

        Optional<SolutionStep> solutionStepFor = getSolutionStep.apply(grid, new Position(0, 0));

        assertTrue(solutionStepFor.isPresent());
        assertEquals(1, solutionStepFor.get().value);
    }

    @Test
    void found() {
        Grid grid = gridWith(List.of("3", "-", "4", "-"),
                             List.of("-", "1", "-", "2"),
                             List.of("-", "4", "-", "3"),
                             List.of("2", "-", "1", "-"));

        Optional<SolutionStep> solutionStepFor = getSolutionStep.apply(grid, new Position(0, 1));

        assertTrue(solutionStepFor.isPresent());
        assertEquals(2, solutionStepFor.get().value);
    }

    @Test
    void notFound() {
        Grid grid = gridWith(List.of("3", "-", "4", "-"),
                             List.of("-", "-", "-", "2"),
                             List.of("-", "4", "-", "3"),
                             List.of("2", "-", "1", "-"));

        Optional<SolutionStep> solutionStepFor = getSolutionStep.apply(grid, new Position(0, 1));

        assertFalse(solutionStepFor.isPresent());
    }
}