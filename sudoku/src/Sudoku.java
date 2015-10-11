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
     * Check the consistency of the input
     *
     * @param matrix
     * @throws IllegalStateException
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
     * @param matrix
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

//    public int getValue() {
//
//
//    }

//
//        if (columnIndex < 0 || columnIndex >= MAX_VALUE) {
//            throw new IndexOutOfBoundsException("'columnIndex' can't be less than 0 nor more than " + MAX_VALUE);
//        }


//    public void updatePossibleValues(Cell[][] matrix) {
//
//        updatePossibleValuesByRow(matrix);
//        updatePossibleValuesByColumn(matrix);
//        updatePossibleValuesBySquare(matrix);
//    }
//
//    private void updatePossibleValuesByRow(Cell[][] matrix) {
//
//        for (int j = 0; j < (MAX_VALUE - 1); j++) {
//
//            if (j == columnIndex) {
//                continue;
//            }
//
//            updatePossibleValue(matrix, rowIndex, j);
//        }
//    }
//
//    private void updatePossibleValuesByColumn(Cell[][] matrix) {
//
//        for (int i = 0; i < (MAX_VALUE - 1); i++) {
//
//            if (i == rowIndex) {
//
//                continue;
//            }
//
//            updatePossibleValue(matrix, i, columnIndex);
//        }
//    }
//
//    private void updatePossibleValuesBySquare(Cell[][] matrix) {
//
//        int columnIndexOfTheCenterOfTheSquare;
//        int rowIndexOfTheCenterOfTheSquare;
//
//        if (rowIndex % SQUARE_LATE == 0) {
//
//            rowIndexOfTheCenterOfTheSquare = rowIndex + 1;
//        } else if (rowIndex % SQUARE_LATE == 2) {
//
//            rowIndexOfTheCenterOfTheSquare = rowIndex - 1;
//        } else {
//
//            rowIndexOfTheCenterOfTheSquare = rowIndex;
//        }
//
//        if (columnIndex % SQUARE_LATE == 0) {
//
//            columnIndexOfTheCenterOfTheSquare = columnIndex + 1;
//        } else if (columnIndex % SQUARE_LATE == 2) {
//
//            columnIndexOfTheCenterOfTheSquare = columnIndex - 1;
//        }
//        else {
//
//            columnIndexOfTheCenterOfTheSquare = columnIndex;
//        }
//
//        for (int i=rowIndexOfTheCenterOfTheSquare-1; i<rowIndexOfTheCenterOfTheSquare+SQUARE_LATE; i++) {
//            for(int j=columnIndexOfTheCenterOfTheSquare-1; j<columnIndexOfTheCenterOfTheSquare+SQUARE_LATE; j++) {
//
//                if(i==rowIndex && j==columnIndex) {
//                    continue;
//                }
//
//                updatePossibleValue(matrix, i, j);
//            }
//        }
//
//    }
//
//    private void updatePossibleValue(Cell[][] matrix, int rowIndex, int columnIndex) {
//
//        Cell cell = matrix[rowIndex][columnIndex];
//
//        if(cell.getValue() != UNASSIGNED_VALUE) {
//
//            int value = cell.getValue();
//
//            if (possibleValues[value - 1]){
//
//                possibleValues[value - 1] = false;
//            }
//        }
//    }
//
}
