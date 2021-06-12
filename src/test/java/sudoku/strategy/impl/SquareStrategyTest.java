package sudoku.strategy.impl;

class SquareStrategyTest extends CellsStrategyContract {

    private final SquareStrategy strategy = new SquareStrategy();

    @Override
    protected CellsStrategy aStrategy() {
        return strategy;
    }
}