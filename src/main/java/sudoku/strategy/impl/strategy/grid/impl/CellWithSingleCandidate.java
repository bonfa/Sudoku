package sudoku.strategy.impl.strategy.grid.impl;

import sudoku.CandidatesFinder;
import sudoku.models.Grid;
import sudoku.strategy.impl.SolutionStep;
import sudoku.strategy.impl.strategy.CellStrategy;

import java.util.Optional;
import java.util.Set;

public class CellWithSingleCandidate implements CellStrategy {

    private final CandidatesFinder candidatesFinder;

    public CellWithSingleCandidate(CandidatesFinder candidatesFinder) {
        this.candidatesFinder = candidatesFinder;
    }

    @Override
    public Optional<SolutionStep> findSolutionStepFor(Grid grid, Grid.Position position) {
        Set<Integer> candidates = candidatesFinder.apply(grid, position).getValues();

        if (candidates.size() == 1)
            return candidates.stream().findFirst().map(value -> new SolutionStep(position, value));

        return Optional.empty();
    }
}
