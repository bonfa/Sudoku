package sudoku;

import org.junit.jupiter.api.Test;
import sudoku.exception.OperationNotAllowedException;
import sudoku.exception.ValueOutOfBoundsException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bonfa on 05/10/15.
 */
public class SudokuTest {

    //-------------------------- Dimensions-----------------------------------

    @Test
    public void testSudokuErrorRowTooLowValues() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Sudoku(new int[][]{}));
    }

    @Test
    public void testSudokuErrorRowTooManyValues() {

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
    public void testSudokuErrorTooLowColumns() {

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
    public void testSudokuErrorTooManyColumns() {

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
    public void testSudokuErrorCheckValuesNegative_1() {

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
    public void testSudokuErrorCheckValuesNegative_2() {

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
    public void testSudokuErrorCheckValuesNegative_3() {

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
    public void testSudokuErrorCheckValuesNegative_4() {

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
    public void testSudokuErrorCheckValuesNegative_5() {

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
    public void testSudokuErrorCheckValuesNegative_6() {

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
    public void testSudokuErrorCheckValuesNegative_7() {

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
    public void testSudokuErrorCheckValuesUpper_1() {

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
    public void testSudokuErrorCheckValuesUpper_2() {

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
    public void testSudokuErrorCheckValuesUpper_3() {

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
    public void testSudokuErrorCheckValuesUpper_4() {

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
    public void testSudokuErrorCheckValuesUpper_5() {

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
    public void testSudokuErrorCheckValuesUpper_6() {

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
    public void testSudokuErrorCheckValuesUpper_7() {

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
    public void testSudokuErrorRowNotConsistentFirst_1() {

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
    public void testSudokuErrorRowNotConsistentFirst_2() {

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
    public void testSudokuErrorRowNotConsistentFirst_3() {

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
    public void testSudokuErrorRowNotConsistentFirst_4() {

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
    public void testSudokuErrorRowNotConsistentFirst_5() {

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
    public void testSudokuErrorRowNotConsistentLast_1() {

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
    public void testSudokuErrorRowNotConsistentLast_2() {

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
    public void testSudokuErrorRowNotConsistentLast_3() {

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
    public void testSudokuErrorRowNotConsistentLast_4() {

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
    public void testSudokuErrorRowNotConsistentLast_5() {

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
    public void testSudokuErrorRowNotConsistentLast() {

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
    public void testSudokuErrorRowNotConsistentMiddle_1() {

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
    public void testSudokuErrorRowNotConsistentMiddle_2() {

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
    public void testSudokuErrorRowNotConsistentMiddle_3() {

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
    public void testSudokuErrorRowNotConsistentMiddle_4() {

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
    public void testSudokuErrorRowNotConsistentMiddle_5() {

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
    public void testSudokuErrorColumnNotConsistentFirst_1() {

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
    public void testSudokuErrorColumnNotConsistentFirst_2() {

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
    public void testSudokuErrorColumnNotConsistentFirst_3() {

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
    public void testSudokuErrorColumnNotConsistentFirst_4() {

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
    public void testSudokuErrorColumnNotConsistentFirst_5() {

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
    public void testSudokuErrorColumnNotConsistentLast_1() {

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
    public void testSudokuErrorColumnNotConsistentLast_2() {

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
    public void testSudokuErrorColumnNotConsistentLast_3() {

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
    public void testSudokuErrorColumnNotConsistentLast_4() {

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
    public void testSudokuErrorColumnNotConsistentLast_5() {

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
    public void testSudokuErrorColumnNotConsistentMiddle_1() {

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
    public void testSudokuErrorColumnNotConsistentMiddle_2() {

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
    public void testSudokuErrorColumnNotConsistentMiddle_3() {

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
    public void testSudokuErrorColumnNotConsistentMiddle_4() {

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
    public void testSudokuErrorColumnNotConsistentMiddle_5() {

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
    public void testSudokuErrorSquareNotConsistentFirst_1() {

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
    public void testSudokuErrorSquareNotConsistentFirst_2() {

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
    public void testSudokuErrorSquareNotConsistentFirst_3() {

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
    public void testSudokuErrorSquareNotConsistentFirst_4() {

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
    public void testSudokuErrorSquareNotConsistentLast_1() {

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
    public void testSudokuErrorSquareNotConsistentLast_2() {

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
    public void testSudokuErrorSquareNotConsistentLast_3() {

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
    public void testSudokuErrorSquareNotConsistentLast_4() {

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
    public void testSudokuErrorSquareNotConsistentMiddle_1() {

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
    public void testSudokuErrorSquareNotConsistentMiddle_2() {

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
    public void testSudokuErrorSquareNotConsistentMiddle_3() {

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
    public void testSudokuErrorSquareNotConsistentMiddle_4() {

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
        assertSame(sudoku.getMatrix(), matrix);
        assertEquals(9, sudoku.getMatrix().length);
        assertEquals(9, sudoku.getMatrix()[0].length);
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                assertFalse(sudoku.getMatrix()[i][j].hasValue());
            }
        }
        assertFalse(sudoku.isComplete());
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
        assertEquals(9, sudoku.getMatrix().length);
        assertEquals(9, sudoku.getMatrix()[0].length);

        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (j == 2 && i == 0) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(1, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 4 && i == 1) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(1, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 6 && i == 2) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(1, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 1 && i == 3) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(2, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 4 && i == 4) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(9, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 7 && i == 4) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(6, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 3 && i == 5) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(7, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 7 && i == 6) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(3, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 1 && i == 7) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(4, sudoku.getMatrix()[i][j].getValue());
                } else if (j == 5 && i == 8) {

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(4, sudoku.getMatrix()[i][j].getValue());
                } else {

                    assertFalse(sudoku.getMatrix()[i][j].hasValue());
                }
            }
        }
        assertFalse(sudoku.isComplete());
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

                assertTrue(sudoku.getMatrix()[i][j].hasValue());
                assertEquals(matrix[i][j], sudoku.getMatrix()[i][j].getValue());
            }
        }
        assertTrue(sudoku.isComplete());
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

                    assertTrue(sudoku.getMatrix()[i][j].hasValue());
                    assertEquals(5, sudoku.getMatrix()[i][j].getValue());

                } else if (i == rowIndex) { //row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == 4) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (j == columnIndex) { //column

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == 4) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (i == rowIndex - 2 && (j == columnIndex - 1 || j == columnIndex + 1)) { // square first row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == 4) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (i == rowIndex - 1 && (j == columnIndex - 1 || j == columnIndex + 1)) { // square second row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == 4) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                    }
                }
            }
        }
    }

    //-------------------------- Update Values -----------------------------------

    @Test
    public void testSudokuUpdateCellValueErrorCellAlreadyHasValue() throws ValueOutOfBoundsException {

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
    public void testSudokuUpdateCellValueErrorCellNewCellWithoutVale() throws ValueOutOfBoundsException {

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

                    assertTrue(sudoku.getMatrix()[rowIndex][columnIndex].hasValue());
                    assertEquals(newValue, sudoku.getMatrix()[rowIndex][columnIndex].getValue());
                } else {

                    assertFalse(sudoku.getMatrix()[i][j].hasValue());
                }
            }
        }

        //possible values
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (i == rowIndex && j == columnIndex) {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }
                } else if (i == rowIndex) { //row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (j == columnIndex) { //column

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (i == rowIndex + 1 && (j == columnIndex - 1 || j == columnIndex - 2)) { // square first row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (i == rowIndex + 2 && (j == columnIndex - 1 || j == columnIndex - 2)) { // square second row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
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

                    assertTrue(sudoku.getMatrix()[rowIndex][columnIndex].hasValue());
                    assertEquals(newValue, sudoku.getMatrix()[rowIndex][columnIndex].getValue());
                } else {

                    assertFalse(sudoku.getMatrix()[i][j].hasValue());
                }
            }
        }

        //possible values
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                if (i == rowIndex && j == columnIndex) {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }
                } else if (i == rowIndex) { //row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (j == columnIndex) { //column

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (i == rowIndex + 1 && (j == columnIndex - 1 || j == columnIndex - 2)) { // square first row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else if (i == rowIndex + 2 && (j == columnIndex - 1 || j == columnIndex - 2)) { // square second row

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        if (k == newValue - 1) {

                            assertFalse(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        } else {

                            assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
                        }
                    }

                } else {

                    for (int k = 0; k < sudoku.getMatrix()[i][j].getPossibleValues().length; k++) {

                        assertTrue(sudoku.getMatrix()[i][j].getPossibleValues()[k]);
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
        assertNull(sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue());
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
        assertTrue(sudoku.hasCellWithoutValueAndOnlyOnePossibleValue());
        assertNotNull(sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue());
        assertEquals(0, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex());
        assertEquals(8, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex());
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
        assertTrue(sudoku.hasCellWithoutValueAndOnlyOnePossibleValue());
        assertNotNull(sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue());
        assertEquals(0, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex());
        assertEquals(8, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex());

        sudoku.setCellValue(new Cell(0, 8, 9), false);

        assertTrue(sudoku.hasCellWithoutValueAndOnlyOnePossibleValue());
        assertNotNull(sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue());
        assertEquals(8, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex());
        assertEquals(0, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex());

        sudoku.setCellValue(new Cell(8, 0, 9), false);
        assertFalse(sudoku.hasCellWithoutValueAndOnlyOnePossibleValue());
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
        assertTrue(sudoku.hasCellWithoutValueAndOnlyOnePossibleValue());
        assertNotNull(sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue());
        assertEquals(0, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex());
        assertEquals(8, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex());

        sudoku.setProperValueToFirstCellWithoutValueAndOnlyOnePossibleValue();

        assertTrue(sudoku.hasCellWithoutValueAndOnlyOnePossibleValue());
        assertNotNull(sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue());
        assertEquals(8, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getRowIndex());
        assertEquals(0, sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue().getColumnIndex());

        sudoku.setProperValueToFirstCellWithoutValueAndOnlyOnePossibleValue();

        assertFalse(sudoku.hasCellWithoutValueAndOnlyOnePossibleValue());
    }

    @Test
    public void testSudokuSetVariableWithOnlyOnePossibleValueError() throws ValueOutOfBoundsException {

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
        assertFalse(sudoku.hasCellWithoutValueAndOnlyOnePossibleValue());
        assertNull(sudoku.getFirstCellWithoutValueAndOnlyOnePossibleValue());

        assertThrows(OperationNotAllowedException.class, sudoku::setProperValueToFirstCellWithoutValueAndOnlyOnePossibleValue);
    }

    //-------------------------- Constructor for cloning -----------------------------------
    @Test()
    public void testCloneConstructor() throws ValueOutOfBoundsException {

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

        assertNotEquals (sudoku, copy);
        assertNotEquals (sudoku.getMatrix(), copy.getMatrix());
        for (int i = 0; i < sudoku.getMatrix().length; i++) {
            for (int j = 0; j < sudoku.getMatrix()[i].length; j++) {

                final Cell sudokuCell = sudoku.getMatrix()[i][j];
                final Cell copyCell = copy.getMatrix()[i][j];

                assertNotEquals (sudokuCell, copyCell);
                assertEquals (sudokuCell.getRowIndex(), copyCell.getRowIndex());
                assertEquals (sudokuCell.getColumnIndex(), copyCell.getColumnIndex());
                assertEquals (sudokuCell.getValue(), copyCell.getValue());
                assertNotEquals (sudokuCell.getPossibleValues(), copyCell.getPossibleValues());
                assertNotEquals (sudokuCell.getPossibleValues(), copyCell.getPossibleValues());
            }
        }
    }
}