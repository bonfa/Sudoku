package sudoku;

import helper.Log;
import sudoku.exception.OperationNotAllowedException;
import sudoku.exception.ValueOutOfBoundsException;

/**
 * Created by bonfa on 05/10/15.
 *
 * The sudoku game to be solved.
 * It is a matrix of {@see Cell} Cell.
 * The matrix keeps update the values of the matrix as well as the possible values that each cell can have.
  */
public final class Sudoku {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int SQUARE_LATE = 3;
    public static final int UNASSIGNED_VALUE = 0;

    private static final String TAG = Sudoku.class.getSimpleName();

    private final Cell[][] mMatrix;

    //Hide default constructor
    private Sudoku() {
        mMatrix = null;
    }

    /**
     * Constructor
     *
     * @param sudoku the cell matrix which represents the sudoku to be solved
     */
    public Sudoku(final Cell[][] sudoku) throws ValueOutOfBoundsException {

        checkConsistency(sudoku);

        this.mMatrix = sudoku;

        updateCellsPossibleValues();
    }

    /**
     * Constructor
     *
     * @param intMatrix the matrix of integer to be converted in cell matrix which represents the sudoku to be solved
     */
    public Sudoku(final int[][] intMatrix) throws ValueOutOfBoundsException {

        final Cell[][] sudoku = intMatrixToCellMatrix(intMatrix);

        checkConsistency(sudoku);

        this.mMatrix = sudoku;

        updateCellsPossibleValues();
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
     * Checks the consistency of the input sudoku matrix by checking that all the rows and the columns have the correct
     * number of boxes, that the values inserted are all between 0 (the undefined value) and 9, and that the number
     * the user inserted are consistent.
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
     * Checks that the sudoku matrix has MAX_VALUE rows and each one has MAX_VALUE columns
     *
     * @param matrix the sudoku matrix
     * @throws ValueOutOfBoundsException
     */
    private static void checkRowAndColumnCount(final Cell[][] matrix) throws ValueOutOfBoundsException {

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
     * Checks that each row of the sudoku matrix in input does not contain more than once the same value
     *
     * @param matrix the sudoku matrix
     * @throws IllegalStateException
     */
    private static void checkRowsConsistency(final Cell[][] matrix) throws IllegalStateException {

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
     * Checks that each column of the sudoku matrix in input does not contain more than once the same value
     *
     * @param matrix the sudoku matrix
     * @throws IllegalStateException
     */
    private static void checkColumnsConsistency(final Cell[][] matrix) throws IllegalStateException {

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
     * Checks that each square of the sudoku matrix in input does not contain the same value more than once
     *
     * @param matrix the sudoku matrix
     * @throws IllegalStateException
     */
    private static void checkSquaresConsistency(final Cell[][] matrix) throws IllegalStateException {

        for (int rowIndex = 0; rowIndex < MAX_VALUE - 1; rowIndex += SQUARE_LATE) {
            for (int columnIndex = 0; columnIndex < MAX_VALUE; columnIndex += SQUARE_LATE) {

                checkSingleSquareConsistency(rowIndex, columnIndex, matrix);
            }
        }
    }

    /**
     * Checks that a square does not contain the same value for more than once
     *
     * @param rowIndex    index of the row of the upper-left box of the square
     * @param columnIndex index of the column of the upper-left box of the square
     * @param matrix      the sudoku matrix
     */
    private static void checkSingleSquareConsistency(final int rowIndex, final int columnIndex, final Cell[][] matrix) {

        for (int rowCount = rowIndex; rowCount < rowIndex + SQUARE_LATE; rowCount++) {
            for (int columnCount = columnIndex; columnCount < columnIndex + SQUARE_LATE; columnCount++) {

                for (int i = rowIndex; i < rowIndex + SQUARE_LATE; i++) {
                    for (int j = columnIndex; j < columnIndex + SQUARE_LATE; j++) {

                        if ((rowCount != i || columnCount != j) && matrix[i][j].hasValue() && matrix[rowCount][columnCount].getValue() == matrix[i][j].getValue()) {
                            throw new IllegalStateException("Box [" + rowCount + "][" + columnCount + "] and [" + i + "][" + j + "] has the same value but are in the same square");
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets the sudoku matrix
     *
     * @return the sudoku matrix
     */
    public Cell[][] getMatrix() {

        return mMatrix;
    }

    /**
     * Gets the completeness of the sudoku
     *
     * A sudoku is complete if and only if it has all the boxes filled consistently
     * The consistency is guaranteed a priori by the structure and the algorithm
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

    /**
     * Updates the possible values of the cells of the sudoku
     */
    private void updateCellsPossibleValues() {

        for (int rowCount = 0; rowCount < MAX_VALUE; rowCount++) {
            for (int columnCount = 0; columnCount < MAX_VALUE; columnCount++) {

                final Cell cell = mMatrix[rowCount][columnCount];

                updateMatrixPossibleValues(cell);
            }
        }
    }

    /**
     * Updates the matrix possible values starting from the value of the cell
     *
     * @param cell the cell whose value is removed from the possible values of the row, the column and the square the
     *             cell belongs to
     */
    private void updateMatrixPossibleValues(final Cell cell) {

        if (cell.hasValue()) {

            try {

                updateMatrixPossibleValuesForRow(cell);
                updateMatrixPossibleValuesForColumn(cell);
                updateMatrixPossibleValuesForSquare(cell);

            } catch (OperationNotAllowedException e) {

                e.printStackTrace();
            }

        } else {

            Log.d(TAG, "cell [" + cell.getRowIndex() + "][" + cell.getColumnIndex() + "] has no value");
        }
    }


    /**
     * Updates the possible values of the cells on the same row of the input cell
     *
     * @Precondition cell.hasValue()
     */
    private void updateMatrixPossibleValuesForRow(final Cell cell) throws OperationNotAllowedException {

        assert cell.hasValue();

        for (int columnIndex = 0; columnIndex < MAX_VALUE; columnIndex++) {

            final Cell rowCell = mMatrix[cell.getRowIndex()][columnIndex];

            if (!rowCell.hasValue() && rowCell.getColumnIndex() != cell.getColumnIndex()) {

                rowCell.setPossibleValue(cell.getValue(), false);
            }
        }
    }

    /**
     * Updates the possible values of the cells on the same column of the input cell
     *
     * @Precondition cell.hasValue()
     */
    private void updateMatrixPossibleValuesForColumn(final Cell cell) throws OperationNotAllowedException {

        assert cell.hasValue();

        for (int rowIndex = 0; rowIndex < MAX_VALUE; rowIndex++) {

            final Cell columnCell = mMatrix[rowIndex][cell.getColumnIndex()];

            if (!columnCell.hasValue() && columnCell.getRowIndex() != cell.getRowIndex()) {
                columnCell.setPossibleValue(cell.getValue(), false);
            }
        }
    }

    /**
     * Updates the possible values of the cells on the same square of the input cell
     *
     * @Precondition cell.hasValue()
     */
    private void updateMatrixPossibleValuesForSquare(final Cell cell) throws OperationNotAllowedException {

        assert cell.hasValue();

        final int rowIndexOfTheCenterOfTheSquare = getRowIndexOfTheCenterOfTheSquare(cell);
        final int columnIndexOfTheCenterOfTheSquare = getColumnIndexOfTheCenterOfTheSquare(cell);

        for (int i = rowIndexOfTheCenterOfTheSquare - 1; i < rowIndexOfTheCenterOfTheSquare + SQUARE_LATE - 1; i++) {
            for (int j = columnIndexOfTheCenterOfTheSquare - 1; j < columnIndexOfTheCenterOfTheSquare + SQUARE_LATE - 1; j++) {

                final Cell squareCell = mMatrix[i][j];

                if (!squareCell.hasValue() && i != cell.getRowIndex() && j != cell.getColumnIndex()) {

                    squareCell.setPossibleValue(cell.getValue(), false);
                }
            }
        }
    }

    /**
     * Gets the column index of the center of square (of late SQUARE_LATE) the cell belongs to
     *
     * @param cell the cell the identifies the square
     * @return the column index of the center of the square of late SQUARE_LATE the cell belongs to
     */
    private int getColumnIndexOfTheCenterOfTheSquare(final Cell cell) {

        int columnIndexOfTheCenterOfTheSquare;
        if (cell.getColumnIndex() % SQUARE_LATE == 0) {

            columnIndexOfTheCenterOfTheSquare = cell.getColumnIndex() + 1;
        } else if (cell.getColumnIndex() % SQUARE_LATE == 2) {

            columnIndexOfTheCenterOfTheSquare = cell.getColumnIndex() - 1;
        } else {

            columnIndexOfTheCenterOfTheSquare = cell.getColumnIndex();
        }
        return columnIndexOfTheCenterOfTheSquare;
    }

    /**
     * Gets the row index of the center of square (of late SQUARE_LATE) the cell belongs to
     *
     * @param cell the cell the identifies the square
     * @return the row index of the center of the square of late SQUARE_LATE the cell belongs to
     */
    private int getRowIndexOfTheCenterOfTheSquare(final Cell cell) {

        int rowIndexOfTheCenterOfTheSquare;
        if (cell.getRowIndex() % SQUARE_LATE == 0) {

            rowIndexOfTheCenterOfTheSquare = cell.getRowIndex() + 1;
        } else if (cell.getRowIndex() % SQUARE_LATE == 2) {

            rowIndexOfTheCenterOfTheSquare = cell.getRowIndex() - 1;
        } else {

            rowIndexOfTheCenterOfTheSquare = cell.getRowIndex();
        }
        return rowIndexOfTheCenterOfTheSquare;
    }

    /**
     * Sets the value a cell of the sudoku.
     *
     * The method can work in two ways: the first one throws an {@see OperationNotAllowedException} if the value of the
     * cell is already present; the second one overrides the value and re-calculates the possible values of the whole matrix
     *
     * @param cellWithValue the cell to be update. It must contain the new value, otherwise the method fires an {@see OperationNotAllowedException}
     * @param resetIfValueAlreadyPresent specifies if the value must be overridden or not
     * @throws OperationNotAllowedException
     * @throws ValueOutOfBoundsException
     */
    public void setCellValue(final Cell cellWithValue, final boolean resetIfValueAlreadyPresent) throws OperationNotAllowedException, ValueOutOfBoundsException {

        if (!cellWithValue.hasValue()) {

            throw new OperationNotAllowedException("cellWithValue must have a value");
        }

        final Cell cellToUpdate = mMatrix[cellWithValue.getRowIndex()][cellWithValue.getColumnIndex()];

        if (resetIfValueAlreadyPresent && cellToUpdate.hasValue()) {

            cellToUpdate.reset();

            resetMatrixPossibleValues();
        }

        cellToUpdate.setValue(cellWithValue.getValue());
        updateMatrixPossibleValues(cellToUpdate);
    }

    /**
     * Resets the matrix possible values and re-calculates each array of possible values starting from the values
     * of the cells of the sudoku
     */
    private void resetMatrixPossibleValues() {

        for (int rowCount = 0; rowCount < MAX_VALUE; rowCount++) {
            for (int columnCount = 0; columnCount < MAX_VALUE; columnCount++) {

                final Cell cell = mMatrix[rowCount][columnCount];

                if (!cell.hasValue()) {

                    cell.resetPossibleValues();
                }
            }
        }

        updateCellsPossibleValues();
    }

}
