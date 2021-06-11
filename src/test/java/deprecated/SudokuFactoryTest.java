package deprecated;

import deprecated.CellV2;
import deprecated.Cells;
import deprecated.SudokuFactory;
import deprecated.SudokuV2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static deprecated.CellV2.cellWithValue;

class SudokuFactoryTest {

    private final SudokuFactory sudokuFactory = new SudokuFactory();

    @Test
    void emptySudoku() {
        SudokuV2 sudoku = sudokuFactory.emptySudoku();

        Assertions.assertEquals(9, sudoku.getCells().size());
        sudoku.getCells().forEach(row -> {
            Assertions.assertEquals(9, row.size());
            row.forEach(cell -> Assertions.assertFalse(cell.hasValue()));
        });
    }

    @Test
    void fromRows() {
        SudokuV2 sudoku = sudokuFactory.fromRows(List.of(
                rowWith(cellWithValue(1), cellWithValue(2), cellWithValue(3), cellWithValue(4), cellWithValue(5), cellWithValue(6), cellWithValue(7), cellWithValue(8), cellWithValue(9)),
                rowWith(cellWithValue(10), cellWithValue(11), cellWithValue(12), cellWithValue(13), cellWithValue(14), cellWithValue(15), cellWithValue(16), cellWithValue(17), cellWithValue(18)),
                rowWith(cellWithValue(19), cellWithValue(20), cellWithValue(21), cellWithValue(22), cellWithValue(23), cellWithValue(24), cellWithValue(25), cellWithValue(26), cellWithValue(27)),
                rowWith(cellWithValue(28), cellWithValue(29), cellWithValue(30), cellWithValue(31), cellWithValue(32), cellWithValue(33), cellWithValue(34), cellWithValue(35), cellWithValue(36)),
                rowWith(cellWithValue(37), cellWithValue(38), cellWithValue(39), cellWithValue(40), cellWithValue(41), cellWithValue(42), cellWithValue(43), cellWithValue(44), cellWithValue(45)),
                rowWith(cellWithValue(46), cellWithValue(47), cellWithValue(48), cellWithValue(49), cellWithValue(50), cellWithValue(51), cellWithValue(52), cellWithValue(53), cellWithValue(54)),
                rowWith(cellWithValue(55), cellWithValue(56), cellWithValue(57), cellWithValue(58), cellWithValue(59), cellWithValue(60), cellWithValue(61), cellWithValue(62), cellWithValue(63)),
                rowWith(cellWithValue(64), cellWithValue(65), cellWithValue(66), cellWithValue(67), cellWithValue(68), cellWithValue(69), cellWithValue(70), cellWithValue(71), cellWithValue(72)),
                rowWith(cellWithValue(73), cellWithValue(74), cellWithValue(75), cellWithValue(76), cellWithValue(77), cellWithValue(78), cellWithValue(79), cellWithValue(80), cellWithValue(81))
        ));

        assertContains(sudoku.getSquares().get(0), 1, 2, 3, 10, 11, 12, 19, 20, 21);
        assertContains(sudoku.getSquares().get(1), 4, 5, 6, 13, 14, 15, 22, 23, 24);
        assertContains(sudoku.getSquares().get(2), 7, 8, 9, 16, 17, 18, 25, 26, 27);
        assertContains(sudoku.getSquares().get(3), 28, 29, 30, 37, 38, 39, 46, 47, 48);
        assertContains(sudoku.getSquares().get(4), 31, 32, 33, 40, 41, 42, 49, 50, 51);
        assertContains(sudoku.getSquares().get(5), 34, 35, 36, 43, 44, 45, 52, 53, 54);
        assertContains(sudoku.getSquares().get(6), 55, 56, 57, 64, 65, 66, 73, 74, 75);
        assertContains(sudoku.getSquares().get(7), 58, 59, 60, 67, 68, 69, 76, 77, 78);
        assertContains(sudoku.getSquares().get(8), 61, 62, 63, 70, 71, 72, 79, 80, 81);

        assertContains(sudoku.getColumns().get(0), 1, 10, 19, 28, 37, 46, 55, 64, 73);
        assertContains(sudoku.getColumns().get(1), 2, 11, 20, 29, 38, 47, 56, 65, 74);
        assertContains(sudoku.getColumns().get(2), 3, 12, 21, 30, 39, 48, 57, 66, 75);
        assertContains(sudoku.getColumns().get(3), 4, 13, 22, 31, 40, 49, 58, 67, 76);
        assertContains(sudoku.getColumns().get(4), 5, 14, 23, 32, 41, 50, 59, 68, 77);
        assertContains(sudoku.getColumns().get(5), 6, 15, 24, 33, 42, 51, 60, 69, 78);
        assertContains(sudoku.getColumns().get(6), 7, 16, 25, 34, 43, 52, 61, 70, 79);
        assertContains(sudoku.getColumns().get(7), 8, 17, 26, 35, 44, 53, 62, 71, 80);
        assertContains(sudoku.getColumns().get(8), 9, 18, 27, 36, 45, 54, 63, 72, 81);
    }

    private void assertContains(Cells cells, int cell_1, int cell_2, int cell_3, int cell_4, int cell_5, int cell_6, int cell_7, int cell_8, int cell_9) {
        assertEquals(cells.getCells(), List.of(cellWithValue(cell_1), cellWithValue(cell_2), cellWithValue(cell_3),
                                               cellWithValue(cell_4), cellWithValue(cell_5), cellWithValue(cell_6),
                                               cellWithValue(cell_7), cellWithValue(cell_8), cellWithValue(cell_9)));
    }

    private Cells rowWith(CellV2... cells) {
        return new Cells(List.of(cells));
    }
}