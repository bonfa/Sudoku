package sudoku.impl.extractors;

import sudoku.models.Cell;

import java.util.Optional;
import java.util.function.Function;

public class CellExtractors {
    public static final Function<Cell, Optional<Integer>> valueExtractor = Cell::getValue;
}
