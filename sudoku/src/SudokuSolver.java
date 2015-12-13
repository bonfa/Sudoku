//import sudoku.Sudoku;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * Created by bonfa on 11/10/15.
// *
// */
//public class SudokuSolver {
//
//    private final Sudoku mSudoku;
//    private final List[][] mPossibleValues;
//
//    //hide default constructor
//    private SudokuSolver() {
//
//        mSudoku = null;
//        mPossibleValues = null;
//    }
//
//
//    public SudokuSolver(final Sudoku sudoku) {
//
//        this.mSudoku = sudoku;
//        this.mPossibleValues = initPossibleValues();
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
//
//
//    private static Sudoku getSudoku() {
//
//        final int[][] matrix = {
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//        };
//
//        return new Sudoku(matrix);
//    }
//}
