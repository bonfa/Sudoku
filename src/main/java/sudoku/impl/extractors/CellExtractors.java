package sudoku.impl.extractors;

import sudoku.impl.models.Cell;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class CellExtractors {
    public static final Function<Cell, Optional<Integer>> valueExtractor = Cell::getValue;

    public static final Predicate<Optional> valueIsPresent = Optional::isPresent;
}
