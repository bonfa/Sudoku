package sudoku.impl.strategy.impl;

import sudoku.models.Grid;
import sudoku.models.Numbers;
import sudoku.models.Position;
import sudoku.models.SolutionStep;

import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static sudoku.impl.strategy.impl.CandidatesFinder.candidatesFinder;
import static sudoku.impl.utilities.Sets.hasSize;

public class CellWithSingleCandidate {

    private static final Predicate<Set> HAS_SIZE_ONE = hasSize.apply(1);

    public static BiFunction<Grid, Position, Optional<SolutionStep>> getSolutionStep = (Grid grid, Position position) -> {
        Numbers candidates = candidatesFinder.apply(grid, position);

        return getSolutionStep(position, candidates);
    };

    private static Optional<SolutionStep> getSolutionStep(Position position, Numbers candidates) {
        var numbers = candidates.getValues();

        if (HAS_SIZE_ONE.test(numbers))
            return numbers.stream().findFirst().map(value -> new SolutionStep(position, value));

        return Optional.empty();
    }
}
