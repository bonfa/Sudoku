package sudoku.strategy.impl;

class RowStrategyTest extends CellsStrategyContract {

    private final RowStrategy strategy = new RowStrategy();

    @Override
    protected CellsStrategy aStrategy() {
        return strategy;
    }
}