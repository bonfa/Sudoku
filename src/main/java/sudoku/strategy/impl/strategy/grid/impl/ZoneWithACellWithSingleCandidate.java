package sudoku.strategy.impl.strategy.grid.impl;

import sudoku.Zone;
import sudoku.strategy.impl.SolutionStep;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ZoneWithACellWithSingleCandidate implements Function<List<Zone>, Optional<SolutionStep>> {
    @Override
    public Optional<SolutionStep> apply(List<Zone> grid) {
        return null;
    }
}
