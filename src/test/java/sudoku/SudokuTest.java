package sudoku;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import sudoku.exception.OperationNotAllowedException;
import sudoku.exception.ValueOutOfBoundsException;

import static org.junit.Assert.assertThrows;

/**
 * Created by bonfa on 05/10/15.
 *
 */
public class SudokuTest {

    private static final String TAG = SudokuTest.class.getSimpleName();

    //-------------------------- Dimensions-----------------------------------

    @Test
    public void testSudokuErrorRowTooLowValues() throws ValueOutOfBoundsException {

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(new int[][]{}));
    }

    @Test
    public void testSudokuErrorRowTooManyValues() throws ValueOutOfBoundsException {

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Sudoku(new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10}
        }));
    }

    @Test
    public void testSudokuErrorTooLowColumns() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9}
        };

        assertThrows(IndexOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorTooManyColumns() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10}
        };

        assertThrows(IndexOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    //-------------------------- Values --------------------------------------------

    @Test
    public void testSudokuErrorCheckValuesNegative_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {-1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesNegative_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, -1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesNegative_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesNegative_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, -1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesNegative_5() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesNegative_6() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, -1}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesNegative_7() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesUpper_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {10, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesUpper_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 10},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesUpper_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {10, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesUpper_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 10},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesUpper_5() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {10, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesUpper_6() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 10}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorCheckValuesUpper_7() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 11, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(matrix));
    }

    //-------------------------- Row Consistency -----------------------------------

    @Test
    public void testSudokuErrorRowNotConsistentFirst_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentFirst_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentFirst_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {1, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentFirst_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentFirst_5() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }


    @Test
    public void testSudokuErrorRowNotConsistentLast_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentLast_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentLast_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentLast_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentLast_5() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentLast() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentMiddle_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentMiddle_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentMiddle_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentMiddle_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorRowNotConsistentMiddle_5() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    //-------------------------- Column Consistency -----------------------------------

    @Test
    public void testSudokuErrorColumnNotConsistentFirst_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentFirst_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentFirst_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentFirst_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentFirst_5() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentLast_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentLast_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentLast_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentLast_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentLast_5() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentMiddle_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentMiddle_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }


    @Test
    public void testSudokuErrorColumnNotConsistentMiddle_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentMiddle_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorColumnNotConsistentMiddle_5() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    //-------------------------- Square Consistency -----------------------------------

    @Test
    public void testSudokuErrorSquareNotConsistentFirst_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentFirst_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentFirst_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentFirst_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentLast_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentLast_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentLast_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentLast_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentMiddle_1() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentMiddle_2() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentMiddle_3() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }

    @Test
    public void testSudokuErrorSquareNotConsistentMiddle_4() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        assertThrows(IllegalStateException.class, () -> new Sudoku(matrix));
    }


    //-------------------------- Second constructor -----------------------------------

    @Test
    public void testSudokuSecondCreatorNoValues() throws ValueOutOfBoundsException {

        final Cell[][] matrix = new Cell[9][9];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = new Cell(i, j);
            }
        }

        final Sudoku sudoku = new Sudoku(matrix);
        assert (sudoku.getMatrix() == matrix);
        assert (sudoku.getMatrix().length == 9);
        assert (sudoku.getMatrix()[0].length == 9);
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                assert (sudoku.getMatrix()[i][j].hasValue() == false);
            }
        }
        assert (sudoku.isComplete() == false);
    }

    //-------------------------- Possible cases -----------------------------------

    @Test
    public void testSudokuWithSomeValues() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 9, 0, 0, 6, 0},
                {0, 0, 0, 7, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 4, 0, 0, 0},
        };

        final Sudoku sudoku = new Sudoku(matrix);
        assert (sudoku.getMatrix().length == 9);
        assert (sudoku.getMatrix()[0].length == 9);

        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (j == 2 && i == 0) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 1);
                } else if (j == 4 && i == 1) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 1);
                } else if (j == 6 && i == 2) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 1);
                } else if (j == 1 && i == 3) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 2);
                } else if (j == 4 && i == 4) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 9);
                } else if (j == 7 && i == 4) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 6);
                } else if (j == 3 && i == 5) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 7);
                } else if (j == 7 && i == 6) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 3);
                } else if (j == 1 && i == 7) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 4);
                } else if (j == 5 && i == 8) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 4);
                } else {

                    assert (sudoku.getMatrix()[i][j].hasValue() == false);
                }
            }
        }
        assert (sudoku.isComplete() == false);
    }

    @Test
    public void testSudokuComplete() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {8, 2, 7, 1, 5, 4, 3, 9, 6},
                {9, 6, 5, 3, 2, 7, 1, 4, 8},
                {3, 4, 1, 6, 8, 9, 7, 5, 2},
                {5, 9, 3, 4, 6, 8, 2, 7, 1},
                {4, 7, 2, 5, 1, 3, 6, 8, 9},
                {6, 1, 8, 9, 7, 2, 4, 3, 5},
                {7, 8, 6, 2, 3, 5, 9, 1, 4},
                {1, 5, 4, 7, 9, 6, 8, 2, 3},
                {2, 3, 9, 8, 4, 1, 5, 6, 7},
        };

        final Sudoku sudoku = new Sudoku(matrix);
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                assert (sudoku.getMatrix()[i][j].hasValue() == true);
                assert (sudoku.getMatrix()[i][j].getValue() == matrix[i][j]);
            }
        }
        assert (sudoku.isComplete() == true);
    }

    //-------------------------- Possible Values -----------------------------------

    @Test()
    public void testSudokuUpdatePossibleValues() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        final int rowIndex = 5;
        final int columnIndex = 4;

        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (i == rowIndex && j == columnIndex) {

                    assert (sudoku.getMatrix()[i][j].hasValue() == true);
                    assert (sudoku.getMatrix()[i][j].getValue() == 5);

                } else if (i == rowIndex) { //row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == 4) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (j == columnIndex) { //column

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == 4) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (i == rowIndex - 2 && (j == columnIndex - 1 || j == columnIndex + 1)) { // square first row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == 4) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (i == rowIndex - 1 && (j == columnIndex - 1 || j == columnIndex + 1)) { // square second row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == 4) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                    }
                }
            }
        }
    }

    //-------------------------- Update Values -----------------------------------

    @Test
    public void testSudokuUpdateCellValueErrorCellAlreadyHasValue() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        final int rowIndex = 3;
        final int columnIndex = 2;

        assertThrows(OperationNotAllowedException.class, () -> sudoku.setCellValue(new Cell(rowIndex, columnIndex, 4), false));
    }

    @Test
    public void testSudokuUpdateCellValueErrorCellNewCellWithoutVale() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        final int rowIndex = 3;
        final int columnIndex = 2;

        assertThrows(OperationNotAllowedException.class, () -> sudoku.setCellValue(new Cell(rowIndex, columnIndex), false));
    }

    @Test()
    public void testSudokuUpdateCellValue() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        final int rowIndex = 3;
        final int columnIndex = 2;
        final int newValue = 4;
        sudoku.setCellValue(new Cell(rowIndex, columnIndex, newValue), false);

        //valori
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (i == rowIndex && j == columnIndex) {

                    assert (sudoku.getMatrix()[rowIndex][columnIndex].hasValue() == true);
                    assert (sudoku.getMatrix()[rowIndex][columnIndex].getValue() == newValue);
                } else {

                    assert (sudoku.getMatrix()[i][j].hasValue() == false);
                }
            }
        }

        //possible values
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (i == rowIndex && j == columnIndex) {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        }
                    }
                }
                else if (i == rowIndex) { //row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (j == columnIndex) { //column

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (i == rowIndex + 1 && (j == columnIndex - 1 || j == columnIndex - 2)) { // square first row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (i == rowIndex + 2 && (j == columnIndex - 1 || j == columnIndex - 2)) { // square second row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                    }
                }
            }
        }
    }

    @Test()
    public void testSudokuUpdateCellWithResetValue() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        final int rowIndex = 3;
        final int columnIndex = 2;
        final int newValue = 4;
        sudoku.setCellValue(new Cell(rowIndex, columnIndex, newValue), true);

        //valori
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (i == rowIndex && j == columnIndex) {

                    assert (sudoku.getMatrix()[rowIndex][columnIndex].hasValue() == true);
                    assert (sudoku.getMatrix()[rowIndex][columnIndex].getValue() == newValue);
                } else {

                    assert (sudoku.getMatrix()[i][j].hasValue() == false);
                }
            }
        }

        //possible values
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (i == rowIndex && j == columnIndex) {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        }
                    }
                }
                else if (i == rowIndex) { //row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (j == columnIndex) { //column

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (i == rowIndex + 1 && (j == columnIndex - 1 || j == columnIndex - 2)) { // square first row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else if (i == rowIndex + 2 && (j == columnIndex - 1 || j == columnIndex - 2)) { // square second row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == false);
                        } else {

                            assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                        }
                    }

                } else {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        assert (sudoku.getMatrix()[i][j].getPossibleValues()[k] == true);
                    }
                }
            }
        }
    }

    //-------------------------- get first cell with one possible value -----------------------------------

    @Test()
    public void testSudokuPossibleValuesNotPresent() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue() == null);
    }

    @Test()
    public void testSudokuPossibleValuesOne() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        assert (sudoku.hasCellWithoutValueAndOnlyOnePossibleValue() == true);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue() != null);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex() == 0);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex() == 8);
    }

    @Test()
    public void testSudokuPossibleValuesTwo() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 5, 6, 4, 3, 2, 1}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        assert (sudoku.hasCellWithoutValueAndOnlyOnePossibleValue() == true);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue() != null);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex() == 0);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex() == 8);

        sudoku.setCellValue(new Cell(0, 8, 9), false);

        assert (sudoku.hasCellWithoutValueAndOnlyOnePossibleValue() == true);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue() != null);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex() == 8);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex() == 0);

        sudoku.setCellValue(new Cell(8, 0, 9), false);
        assert (sudoku.hasCellWithoutValueAndOnlyOnePossibleValue() == false);
    }

    @Test()
    public void testSudokuSetVariableWithOnlyOnePossibleValue() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 5, 6, 4, 3, 2, 1}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        assert (sudoku.hasCellWithoutValueAndOnlyOnePossibleValue() == true);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue() != null);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex() == 0);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex() == 8);

        sudoku.setProperValueToFirstCellWithoutValueAndOnlyOnePossibleValue();

        assert (sudoku.hasCellWithoutValueAndOnlyOnePossibleValue() == true);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue() != null);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex() == 8);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex() == 0);

        sudoku.setProperValueToFirstCellWithoutValueAndOnlyOnePossibleValue();

        assert (sudoku.hasCellWithoutValueAndOnlyOnePossibleValue() == false);
    }

    @Test
    public void testSudokuSetVariableWithOnlyOnePossibleValueError() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 8, 7, 5, 6, 4, 3, 2, 1}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        assert (sudoku.hasCellWithoutValueAndOnlyOnePossibleValue() == false);
        assert (sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue() == null);

        assertThrows(OperationNotAllowedException.class, () -> sudoku.setProperValueToFirstCellWithoutValueAndOnlyOnePossibleValue());
    }

    //-------------------------- Constructor for cloning -----------------------------------
    @Test()
    public void testCloneConstructor() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {9, 8, 7, 5, 6, 4, 3, 2, 1}
        };

        final Sudoku sudoku = new Sudoku(matrix);
        final Sudoku copy = new Sudoku(sudoku);

        assert(sudoku != copy);
        assert(sudoku.getMatrix() != copy.getMatrix());
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                final Cell sudokuCell = sudoku.getMatrix()[i][j];
                final Cell copyCell = copy.getMatrix()[i][j];

                assert(sudokuCell != copyCell);
                assert(sudokuCell.getRowIndex() == copyCell.getRowIndex());
                assert(sudokuCell.getColumnIndex() == copyCell.getColumnIndex());
                assert(sudokuCell.getValue() == copyCell.getValue());
                assert(sudokuCell.getPossibleValues() != copyCell.getPossibleValues());
                assert(ArrayUtils.isEquals(sudokuCell.getPossibleValues(), copyCell.getPossibleValues()));
            }
        }
    }

}