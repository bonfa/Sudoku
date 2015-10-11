/**
 * Created by bonfa on 11/10/15.
 *
 */
public class SudokuSolver {

    private Sudoku sudoku;

    //hide default constructor
    private SudokuSolver() {}


    public SudokuSolver(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

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
