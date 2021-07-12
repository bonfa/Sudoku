package sudoku.impl.utilities;

import java.util.Optional;
import java.util.function.Predicate;

public class Optionals {
    public static final Predicate<Optional> valueIsPresent = Optional::isPresent;
}
