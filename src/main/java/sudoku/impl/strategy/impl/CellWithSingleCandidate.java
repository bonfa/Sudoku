package sudoku.impl.strategy.impl;

import sudoku.impl.models.Grid;
import sudoku.impl.models.Numbers;
import sudoku.impl.models.Position;
import sudoku.impl.models.SolutionStep;

import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static sudoku.impl.utilities.Sets.hasSize;

public class CellWithSingleCandidate implements BiFunction<Grid, Position, Optional<SolutionStep>> {

    private static final Predicate<Set> HAS_SIZE_ONE = hasSize.apply(1);

    private final BiFunction<Grid, Position, Numbers> candidatesFinder;

    public CellWithSingleCandidate(BiFunction<Grid, Position, Numbers> candidatesFinder) {
        this.candidatesFinder = candidatesFinder;
    }

    @Override
    public Optional<SolutionStep> apply(Grid grid, Position position) {
        Set<Integer> candidates = candidatesFinder.andThen(Numbers::getValues).apply(grid, position);

        if (HAS_SIZE_ONE.test(candidates))
            return candidates.stream().findFirst().map(value -> new SolutionStep(position, value));

        return Optional.empty();
    }
}
