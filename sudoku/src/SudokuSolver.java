import sudoku.Sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by bonfa on 11/10/15.
 *
 */
public class SudokuSolver {

    private final Sudoku mSudoku;
    private final List[][] mPossibleValues;

    //hide default constructor
    private SudokuSolver() {

        mSudoku = null;
        mPossibleValues = null;
    }


    public SudokuSolver(final Sudoku sudoku) {

        this.mSudoku = sudoku;
        this.mPossibleValues = initPossibleValues();
    }

    public List[][] initPossibleValues() {

        final List[][] possibleValues = new List[Sudoku.MAX_VALUE][Sudoku.MAX_VALUE];

        for(int i=0; i<Sudoku.MAX_VALUE; i++) {

            for(int j=0; j< Sudoku.MAX_VALUE; j++) {

                possibleValues[i][j] = getAllPossibleValuesList();
            }
        }

        //TODO fix
        return possibleValues;
    }

    private List getAllPossibleValuesList() {

        final List<Integer> integerList = new ArrayList<>(Sudoku.MAX_VALUE);
        for (int i=0; i<Sudoku.MAX_VALUE; i++) {

            integerList.set(i, i);
        }

        return integerList;
    }

//    public void updatePossibleValues(sudoku.Cell[][] matrix) {

//        }
//            updatePossibleValue(matrix, rowIndex, j);
//
//            }
//                continue;
//            if (j == columnIndex) {
//
//        for (int j = 0; j < (MAX_VALUE - 1); j++) {
//
//    private void updatePossibleValuesByRow(sudoku.Cell[][] matrix) {
//
//    }
//        updatePossibleValuesBySquare(matrix);
//        updatePossibleValuesByColumn(matrix);
//        updatePossibleValuesByRow(matrix);
//

//    }
//
//    private void updatePossibleValuesByColumn(sudoku.Cell[][] matrix) {
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
//    private void updatePossibleValuesBySquare(sudoku.Cell[][] matrix) {
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
//    private void updatePossibleValue(sudoku.Cell[][] matrix, int rowIndex, int columnIndex) {
//
//        sudoku.Cell cell = matrix[rowIndex][columnIndex];
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

//    public static void main(final String[][] args) {
//
//        final Sudoku sudoku = getSudoku();
//        final SudokuSolver solver = new SudokuSolver(sudoku);
//
//        try {
//
//            final Sudoku solution = solver.solve();
//
//            printSudoku(solution);
//
//        } catch (final Exception e) {
//
//            e.printStackTrace();
//
//            System.out.println("Impossibile risolvere il sudoku");
//        }
//    }
//
//
//    private static void printSudoku(final Sudoku solution) {
//
//        final int[][] solutionMatrix = solution.getMatrix();
//
//        System.out.print("Solution:\n");
//        for (int i = 0; i < Sudoku.MAX_VALUE; i++) {
//
//            for (int j = 0; j < Sudoku.MAX_VALUE; j++) {
//
//                System.out.print(solutionMatrix[i][j] + "\t");
//            }
//
//            System.out.print("\n\n");
//        }
//
//        System.out.print("\n\n");
//    }


    private static Sudoku getSudoku() {

        final int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        return new Sudoku(matrix);
    }
}
