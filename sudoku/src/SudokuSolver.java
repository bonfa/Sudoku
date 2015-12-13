import helper.Log;
import sudoku.Cell;
import sudoku.Sudoku;
import sudoku.exception.OperationNotAllowedException;
import sudoku.exception.ValueOutOfBoundsException;


/**
 * Created by bonfa on 11/10/15.
 */
public class SudokuSolver {

    private static final String TAG = SudokuSolver.class.getSimpleName();

    private final Sudoku mSudoku;

    //hide default constructor
    private SudokuSolver() {

        mSudoku = null;
    }

    public SudokuSolver(final Sudoku sudoku) {

        this.mSudoku = sudoku;
    }

    public static void main(final String[] args) throws ValueOutOfBoundsException, OperationNotAllowedException {

        final Sudoku sudoku = getSudoku();
        final SudokuSolver solver = new SudokuSolver(sudoku);

        try {

            final Sudoku solution = solver.solve();

            printSudoku(solution);

        } catch (final Exception e) {

            e.printStackTrace();

            System.out.println("Impossibile risolvere il sudoku");
        }
    }

    private Sudoku solve() throws OperationNotAllowedException, ValueOutOfBoundsException {

        while (!mSudoku.isComplete() && mSudoku.hasCellWithoutValueAndOnlyOnePossibleValue()) {

            printSudoku(mSudoku);

            mSudoku.setProperValueToFirstCellWithoutValueAndOnlyOnePossibleValue();
        }

        return mSudoku;
    }


    private static void printSudoku(final Sudoku solution) {

        final Cell[][] solutionMatrix = solution.getMatrix();

        System.out.print("Solution:\n");
        for (int i = 0; i < Sudoku.MAX_VALUE; i++) {

            for (int j = 0; j < Sudoku.MAX_VALUE; j++) {

                String value = "";
                if (solutionMatrix[i][j].hasValue()) {

                    value = Integer.toString(solutionMatrix[i][j].getValue());
                }
                else {

                    value = "_";
                }

                System.out.print(value + "\t");
            }

            System.out.print("\n\n");
        }

        System.out.print("\n\n");
    }


    private static Sudoku getSudoku() throws ValueOutOfBoundsException {

        final int[][] matrix = {
                {6, 3, 8, 1, 0, 0, 0, 0, 9},
                {0, 1, 0, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 6, 1, 3},
                {2, 7, 6, 0, 0, 3, 8, 0, 5},
                {0, 5, 4, 7, 0, 8, 9, 2, 0},
                {9, 0, 1, 2, 0, 0, 7, 3, 6},
                {8, 2, 3, 5, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 9, 0},
                {7, 0, 0, 0, 0, 1, 5, 6, 2},
        };

        return new Sudoku(matrix);
    }
}
