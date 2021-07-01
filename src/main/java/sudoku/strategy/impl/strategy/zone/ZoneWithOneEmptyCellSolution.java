package sudoku.strategy.impl.strategy.zone;

import sudoku.Cell;
import sudoku.Zone;
import sudoku.strategy.impl.SolutionStep;
import sudoku.utilities.Sets;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZoneWithOneEmptyCellSolution implements Function<List<Zone>, Optional<SolutionStep>> {
    private final Predicate<Cell> isEmpty = c -> c.getValue().isEmpty();
    private final Predicate<Cell> hasValue = isEmpty.negate();
    private final Predicate<Zone> hasOneEmptyCell = r -> r.cells.stream().filter(isEmpty).count() == 1;

    @Override
    public Optional<SolutionStep> apply(List<Zone> zones) {
        return zones.stream()
                    .filter(hasOneEmptyCell)
                    .findFirst()
                    .map(this::findSolutionStepFor);
    }

    private SolutionStep findSolutionStepFor(Zone zone) {
        Cell cell = zone.cells.stream().filter(isEmpty).collect(Collectors.toList()).get(0);

        return new SolutionStep(cell.getRowIndex(),
                                cell.getColumnIndex(),
                                getValue(zone));
    }

    private Integer getValue(Zone zone) {
        Set<Integer> valuesAlreadyPresent = zone.cells.stream()
                                                      .filter(hasValue)
                                                      .map(Cell::getValue)
                                                      .flatMap(Optional::stream)
                                                      .collect(Collectors.toSet());

        return Sets.difference(candidates(zone), valuesAlreadyPresent).stream().findFirst().get();
    }

    //TODO duplicated in Grid
    private Set<Integer> candidates(Zone zone) {
        return IntStream.rangeClosed(1, zone.cells.size()).boxed().collect(Collectors.toSet());
    }
}
