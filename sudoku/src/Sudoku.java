import javax.activation.UnsupportedDataTypeException;

/**
 * Created by bonfa on 05/10/15.
 *
 */
public class Sudoku {

    public static final int MAX_VALUE = 9;
    public static final int UNASSIGNED_VALUE = 0;
    public static final int SQUARE_LATE = 3;

    private final int[][] matrix;

    //Hide default constructor
    private Sudoku() {
        matrix = null;
    }

    /**
     * Constructor
     *
     * @param sudoku the sudoku to solve
     */
    public Sudoku(int[][] sudoku) {

        checkConsistency(sudoku);

        this.matrix = sudoku;
    }


    /**
     * Check the consistency of the input by checking that all the rows and the columns have the correct number of boxes,
     * that the values inserted are all between 0 (the undefined value) and 9, and that the number the user inserted
     * are consistent.
     * A row is consistent if and only if it does not contain repeated defined values
     * A column is consistent if and only if it does not contain repeated defined values
     * A square is consistent if and only if it does not contain repeated defined values
     *
     * @param matrix the sudoku matrix
     * @throws IndexOutOfBoundsException if the input row and the columns have lenght different from 9
     * @throws IllegalStateException if the input matrix in not consistent
     */
    private void checkConsistency(int[][] matrix) throws IllegalStateException, IndexOutOfBoundsException {

        checkRowAndColumnCount(matrix);

        checkValues(matrix);

        checkRowsConsistency(matrix);

        checkColumnsConsistency(matrix);

        checkSquaresConsistency(matrix);
    }

    /**
     * Check that all the numbers inserted are between the undefined value and the max value
     *
     * @param matrix the sudoku matrix
     */
    private void checkValues(int[][] matrix) throws IllegalStateException {

        for (int rowIndex = 0; rowIndex < MAX_VALUE; rowIndex++) {

            for (int columnIndex = 0; columnIndex < MAX_VALUE; columnIndex++) {

                if (matrix[rowIndex][columnIndex] < UNASSIGNED_VALUE || matrix[rowIndex][columnIndex] > MAX_VALUE) {

                    throw new IllegalStateException("Box [" + rowIndex + "][" + columnIndex + "] has value out of bounds");
                }
            }
        }
    }

    /**
     * Check that the matrix has 9 rows and each one has 9 columns
     *
     * @param matrix
     * @throws IndexOutOfBoundsException
     */
    private void checkRowAndColumnCount(int[][] matrix) throws IndexOutOfBoundsException {

        if (matrix.length != MAX_VALUE) {
            throw new IndexOutOfBoundsException("input matrix must have '" + MAX_VALUE + "' rows ");
        }

        for (int rowCount = 0; rowCount < matrix.length; rowCount++) {

            if (matrix[rowCount].length != MAX_VALUE) {
                throw new IndexOutOfBoundsException("column " + (rowCount + 1) + " must contain " + MAX_VALUE + "columns");
            }
        }
    }

    /**
     * Check that each row does not contain more than once the same value
     *
     * @param matrix
     * @throws IllegalStateException
     */
    private void checkRowsConsistency(int[][] matrix) throws IllegalStateException {

        for (int rowIndex = 0; rowIndex < MAX_VALUE; rowIndex++) {

            //skip the last element --> from 0 to 7
            for (int columnIndex = 0; columnIndex < (MAX_VALUE - 1); columnIndex++) {

                // columnIndex = 2 --> check elements from 3 to 8
                for (int i = columnIndex + 1; i < (matrix[rowIndex].length); i++) {

                    // i can have more than one unassigned value
                    if (matrix[rowIndex][columnIndex] != UNASSIGNED_VALUE && matrix[rowIndex][columnIndex] == matrix[rowIndex][i]) {

                        throw new IllegalStateException("Row number " + (rowIndex + 1) + " contains more than one box with value " + matrix[rowIndex][columnIndex]);
                    }
                }
            }
        }
    }

    /**
     * Check that each column does not contain more than once the same value
     *
     * @param matrix
     * @throws IllegalStateException
     */
    private void checkColumnsConsistency(int[][] matrix) throws IllegalStateException {

        for (int columnIndex = 0; columnIndex < MAX_VALUE; columnIndex++) {

            //skip the last element --> from 0 to 7
            for (int rowIndex = 0; rowIndex < MAX_VALUE - 1; rowIndex++) {

                for (int j = rowIndex + 1; j < MAX_VALUE; j++) {

                    if (matrix[rowIndex][columnIndex] != UNASSIGNED_VALUE && matrix[rowIndex][columnIndex] == matrix[j][columnIndex]) {

                        throw new IllegalStateException("Column number " + (rowIndex + 1) + " contains more than one box with value " + matrix[rowIndex][columnIndex]);
                    }
                }
            }
        }
    }

    /**
     * Check that each square of the sudoku does not contain the same value more than once
     *
     * @param matrix
     * @throws IllegalStateException
     */
    private void checkSquaresConsistency(int[][] matrix) throws IllegalStateException {

        for (int rowIndex = 0; rowIndex < MAX_VALUE - 1; rowIndex += SQUARE_LATE) {
            for (int columnIndex = 0; columnIndex < MAX_VALUE; columnIndex += SQUARE_LATE) {

                checkSingleSquareConsistency(rowIndex, columnIndex, matrix);
            }
        }
    }

    /**
     * Check that a square does not contain the same value for more than once
     *
     * @param rowIndex    index of the row of the upper-left box of the square
     * @param columnIndex index of the column of the upper-left box of the square
     * @param matrix      the sudoku matrix
     */
    private void checkSingleSquareConsistency(int rowIndex, int columnIndex, int[][] matrix) {

        for (int rowCount = rowIndex; rowCount < rowIndex + SQUARE_LATE; rowCount++) {
            for (int columnCount = columnIndex; columnCount < columnIndex + SQUARE_LATE; columnCount++) {

                for (int i = rowCount; i < rowIndex + SQUARE_LATE; i++) {
                    for (int j = columnCount; j < columnIndex + SQUARE_LATE; j++) {

                        if (matrix[rowCount][columnCount] == matrix[i][j] && matrix[i][j] != UNASSIGNED_VALUE) {
                            throw new IllegalStateException("Box [" + rowCount + "][" + columnCount + "] and [" + i + "][" + j + "] has the same value but are in the same square");
                        }
                    }
                }
            }
        }
    }

    public int[][] getMatrix() {

        return matrix;
    }

    /**
     * A sudoku is complete if and only if it has all the boxes filled consistently
     *
     * @return true if the sudoku is complete, false otherwise
     */
    public boolean isComplete() {

        for (int rowCount = 0; rowCount < MAX_VALUE; rowCount++) {
            for (int columnCount = 0; columnCount < MAX_VALUE; columnCount++) {

                if (matrix[rowCount][columnCount] == UNASSIGNED_VALUE) {
                    return false;
                }
            }
        }

        return true;
    }
}
