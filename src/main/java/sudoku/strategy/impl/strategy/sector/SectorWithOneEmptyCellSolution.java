package sudoku.strategy.impl.strategy.sector;

import sudoku.Cell;
import sudoku.Sector;
import sudoku.strategy.impl.SolutionStep;
import sudoku.utilities.Sets;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SectorWithOneEmptyCellSolution implements Function<List<Sector>, Optional<SolutionStep>> {
    private final Predicate<Cell> isEmpty = c -> c.getValue().isEmpty();
    private final Predicate<Cell> hasValue = isEmpty.negate();
    private final Predicate<Sector> hasOneEmptyCell = r -> r.cells.stream().filter(isEmpty).count() == 1;

    @Override
    public Optional<SolutionStep> apply(List<Sector> sectors) {
        return sectors.stream()
                      .filter(hasOneEmptyCell)
                      .findFirst()
                      .map(this::findSolutionStepFor);
    }

    private SolutionStep findSolutionStepFor(Sector sector) {
        Cell cell = sector.cells.stream().filter(isEmpty).collect(Collectors.toList()).get(0);

        return new SolutionStep(cell.getRowIndex(),
                                cell.getColumnIndex(),
                                getValue(sector));
    }

    private Integer getValue(Sector sector) {
        Set<Integer> valuesAlreadyPresent = sector.cells.stream()
                                                        .filter(hasValue)
                                                        .map(Cell::getValue)
                                                        .flatMap(Optional::stream)
                                                        .collect(Collectors.toSet());

        return Sets.difference(allPossibleValues(sector), valuesAlreadyPresent).stream().findFirst().get();
    }

    //TODO duplicated in Grid
    private Set<Integer> allPossibleValues(Sector sector) {
        return IntStream.rangeClosed(1, sector.cells.size()).boxed().collect(Collectors.toSet());
    }
}
