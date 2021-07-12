package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.models.Cell;
import sudoku.models.Grid;
import sudoku.models.Position;
import sudoku.models.Zone;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetSquaresTest {

    private final Function<Grid, List<Zone>> getSquares = GridExtractors.squaresExtractor;

    @Test
    void getSquares() {
        Grid grid = new Grid(List.of(
                List.of(cellWithValue(1), cellWithValue(2), cellWithValue(3), cellWithValue(4), cellWithValue(5), cellWithValue(6), cellWithValue(7), cellWithValue(8), cellWithValue(9)),
                List.of(cellWithValue(10), cellWithValue(11), cellWithValue(12), cellWithValue(13), cellWithValue(14), cellWithValue(15), cellWithValue(16), cellWithValue(17), cellWithValue(18)),
                List.of(cellWithValue(19), cellWithValue(20), cellWithValue(21), cellWithValue(22), cellWithValue(23), cellWithValue(24), cellWithValue(25), cellWithValue(26), cellWithValue(27)),
                List.of(cellWithValue(28), cellWithValue(29), cellWithValue(30), cellWithValue(31), cellWithValue(32), cellWithValue(33), cellWithValue(34), cellWithValue(35), cellWithValue(36)),
                List.of(cellWithValue(37), cellWithValue(38), cellWithValue(39), cellWithValue(40), cellWithValue(41), cellWithValue(42), cellWithValue(43), cellWithValue(44), cellWithValue(45)),
                List.of(cellWithValue(46), cellWithValue(47), cellWithValue(48), cellWithValue(49), cellWithValue(50), cellWithValue(51), cellWithValue(52), cellWithValue(53), cellWithValue(54)),
                List.of(cellWithValue(55), cellWithValue(56), cellWithValue(57), cellWithValue(58), cellWithValue(59), cellWithValue(60), cellWithValue(61), cellWithValue(62), cellWithValue(63)),
                List.of(cellWithValue(64), cellWithValue(65), cellWithValue(66), cellWithValue(67), cellWithValue(68), cellWithValue(69), cellWithValue(70), cellWithValue(71), cellWithValue(72)),
                List.of(cellWithValue(73), cellWithValue(74), cellWithValue(75), cellWithValue(76), cellWithValue(77), cellWithValue(78), cellWithValue(79), cellWithValue(80), cellWithValue(81))
        ));

        var squares = getSquares.apply(grid);

        assertCellContainsValues(squares.get(0), Set.of(1, 2, 3, 10, 11, 12, 19, 20, 21));
        assertCellContainsValues(squares.get(1), Set.of(4, 5, 6, 13, 14, 15, 22, 23, 24));
        assertCellContainsValues(squares.get(2), Set.of(7, 8, 9, 16, 17, 18, 25, 26, 27));
        assertCellContainsValues(squares.get(3), Set.of(28, 29, 30, 37, 38, 39, 46, 47, 48));
        assertCellContainsValues(squares.get(4), Set.of(31, 32, 33, 40, 41, 42, 49, 50, 51));
        assertCellContainsValues(squares.get(5), Set.of(34, 35, 36, 43, 44, 45, 52, 53, 54));
        assertCellContainsValues(squares.get(6), Set.of(55, 56, 57, 64, 65, 66, 73, 74, 75));
        assertCellContainsValues(squares.get(7), Set.of(58, 59, 60, 67, 68, 69, 76, 77, 78));
        assertCellContainsValues(squares.get(8), Set.of(61, 62, 63, 70, 71, 72, 79, 80, 81));
    }

    private Cell cellWithValue(int value) {
        return Cell.cellWithValue(value, new Position(0, 0));
    }

    private void assertCellContainsValues(Zone zone, Set<Integer> values) {
        var expected = zone.cells.stream().flatMap(c -> c.getValue().stream()).collect(Collectors.toSet());

        assertEquals(expected, values);
    }
}