package sudoku;

import sudoku.exception.ValueOutOfBoundsException;

/**
 * Created by bonfa on 05/10/15.
 *
 */
public final class Sudoku {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int SQUARE_LATE = 3;
    public static final int UNASSIGNED_VALUE = 0;

    private final Cell[][] mMatrix;

    //Hide default constructor
    private Sudoku() {
        mMatrix = null;
    }

    /**
     * Constructor
     *
     * @param sudoku the sudoku to solve
     */
    public Sudoku(final Cell[][] sudoku) throws ValueOutOfBoundsException {

        checkConsistency(sudoku);

        this.mMatrix = sudoku;
    }

    /**
     * Constructor
     *
     * @param intMatrix the matrix of integer to be converted to sudoku and solved
     */
    public Sudoku(final int[][] intMatrix) throws ValueOutOfBoundsException {

        final Cell[][] sudoku = intMatrixToCellMatrix(intMatrix);

        checkConsistency(sudoku);

        this.mMatrix = sudoku;
    }

    /**
     * Creates a Cell matrix starting from an integer matrix
     *
     * @param intMatrix the integer matrix to be converted into a cell matrix
     * @return the matrix of Cell
     * @throws ValueOutOfBoundsException if the indexes of the row or the column are out of the bounds or the value of
     *                                   the cell is out of bounds
     */
    private static Cell[][] intMatrixToCellMatrix(final int[][] intMatrix) throws ValueOutOfBoundsException {

        if (intMatrix.length == 0) {
            throw new ValueOutOfBoundsException("the matrix og integer must have at least lenght 1");
        }

        final Cell[][] cellMatrix = new Cell[intMatrix.length][intMatrix[0].length];

        for (int i = 0; i < intMatrix.length; i++) {

            for (int j = 0; j < intMatrix.length; j++) {

                if (intMatrix[i][j] == UNASSIGNED_VALUE) {

                    cellMatrix[i][j] = new Cell(i, j);
                } else {

                    cellMatrix[i][j] = new Cell(i, j, intMatrix[i][j]);
                }
            }
        }

        return cellMatrix;
    }


    /**
     * Check the consistency of the input by checking that all the rows and the columns have the correct number of boxes,
     * that the values inserted are all between 0 (the undefined value) and 9, and that the number the user inserted
     * are consistent.
     * A row is consistent if and only if it does not contain repeated defined values
     * A column is consistent if and only if it does not contain repeated defined values
     * A square is consistent if and only if it does not contain repeated defined values
     *
     * @param matrix the sudoku mMatrix
     * @throws ValueOutOfBoundsException if the input row and the columns have length different from MAX_VALUE
     * @throws IllegalStateException     if the input mMatrix in not consistent
     */
    private void checkConsistency(final Cell[][] matrix) throws IllegalStateException, ValueOutOfBoundsException {

        checkRowAndColumnCount(matrix);

        checkRowsConsistency(matrix);

        checkColumnsConsistency(matrix);

        checkSquaresConsistency(matrix);
    }

    /**
     * Check that the mMatrix has MAX_VALUE rows and each one has MAX_VALUE columns
     *
     * @param matrix
     * @throws ValueOutOfBoundsException
     */
    private void checkRowAndColumnCount(final Cell[][] matrix) throws ValueOutOfBoundsException {

        if (matrix.length != MAX_VALUE) {
            throw new ValueOutOfBoundsException("input mMatrix must have '" + MAX_VALUE + "' rows ");
        }

        for (int rowCount = 0; rowCount < matrix.length; rowCount++) {

            if (matrix[rowCount].length != MAX_VALUE) {
                throw new ValueOutOfBoundsException("column " + (rowCount + 1) + " must contain " + MAX_VALUE + "columns");
            }
        }
    }

    /**
     * Check that each row does not contain more than once the same value
     *
     * @param matrix
     * @throws IllegalStateException
     */
    private void checkRowsConsistency(final Cell[][] matrix) throws IllegalStateException {

        for (int rowIndex = 0; rowIndex < MAX_VALUE; rowIndex++) {

            //skip the last element --> from 0 to 7
            for (int columnIndex = 0; columnIndex < (MAX_VALUE - 1); columnIndex++) {

                // columnIndex = 2 --> check elements from 3 to 8
                for (int i = columnIndex + 1; i < (matrix[rowIndex].length); i++) {

                    // I can have more than one unassigned value
                    if (matrix[rowIndex][columnIndex].hasValue() && matrix[rowIndex][columnIndex].getValue() == matrix[rowIndex][i].getValue()) {

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
    private void checkColumnsConsistency(final Cell[][] matrix) throws IllegalStateException {

        for (int columnIndex = 0; columnIndex < MAX_VALUE; columnIndex++) {

            //skip the last element --> from 0 to 7
            for (int rowIndex = 0; rowIndex < MAX_VALUE - 1; rowIndex++) {

                for (int j = rowIndex + 1; j < MAX_VALUE; j++) {

                    if (matrix[rowIndex][columnIndex].hasValue() && matrix[rowIndex][columnIndex].getValue() == matrix[j][columnIndex].getValue()) {

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
    private void checkSquaresConsistency(final Cell[][] matrix) throws IllegalStateException {

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
     * @param matrix      the sudoku mMatrix
     */
    private void checkSingleSquareConsistency(final int rowIndex, final int columnIndex, final Cell[][] matrix) {

        for (int rowCount = rowIndex; rowCount < rowIndex + SQUARE_LATE; rowCount++) {
            for (int columnCount = columnIndex; columnCount < columnIndex + SQUARE_LATE; columnCount++) {

                for (int i = rowIndex; i < rowIndex + SQUARE_LATE; i++) {
                    for (int j = columnIndex; j < columnIndex + SQUARE_LATE; j++) {

                        if ((rowCount != i  || columnCount != j) && matrix[i][j].hasValue() && matrix[rowCount][columnCount].getValue() == matrix[i][j].getValue()) {
                            throw new IllegalStateException("Box [" + rowCount + "][" + columnCount + "] and [" + i + "][" + j + "] has the same value but are in the same square");
                        }
                    }
                }
            }
        }
    }

    public Cell[][] getMatrix() {

        return mMatrix;
    }

    /**
     * A sudoku is complete if and only if it has all the boxes filled consistently
     * The consinstency is guaranteed by the algorithm
     *
     * @return true if the sudoku is complete, false otherwise
     */
    public boolean isComplete() {

        for (int rowCount = 0; rowCount < MAX_VALUE; rowCount++) {
            for (int columnCount = 0; columnCount < MAX_VALUE; columnCount++) {

                if (!mMatrix[rowCount][columnCount].hasValue()) {
                    return false;
                }
            }
        }

        return true;
    }
}
