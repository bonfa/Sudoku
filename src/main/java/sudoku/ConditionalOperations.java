package sudoku;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class ConditionalOperations {

    @FunctionalInterface
    public interface If<A, B, C> {
        BiFunction<A, B, C> apply(BiPredicate<A, B> condition,
                                  BiFunction<A, B, C> positiveResultProvider,
                                  BiFunction<A, B, C> negativeResultProvider);
    }

    public static If<Grid, Grid.Position, Numbers> iff =
            (BiPredicate<Grid, Grid.Position> condition,
             BiFunction<Grid, Grid.Position, Numbers> trueProvider,
             BiFunction<Grid, Grid.Position, Numbers> falseProvider) ->
                    (Grid grid, Grid.Position position) -> condition.test(grid, position) ?
                            trueProvider.apply(grid, position) :
                            falseProvider.apply(grid, position);
}
