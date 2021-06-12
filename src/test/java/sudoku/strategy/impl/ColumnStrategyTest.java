package sudoku.strategy.impl;

class ColumnStrategyTest extends CellsStrategyContract {

    private final ColumnStrategy strategy = new ColumnStrategy();

    @Override
    protected CellsStrategy aStrategy() {
        return strategy;
    }
}