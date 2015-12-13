package sudoku;

import helper.Log;
import sudoku.exception.OperationNotAllowedException;
import sudoku.exception.ValueOutOfBoundsException;

import java.security.InvalidParameterException;

/**
 * Created by bonfa on 07/12/15.
 * <p>
 * This is the building block of the sudoku. It represents a single cell of the sudoku.
 * As such, it has a row index, a column index, a value and a set of the possible values.
 * The index of the row and the column in the matrix of the sudoku are immutable and can
 * be defined only at construction time. The value and the possible values, instead, can be updated
 * after the cell has been created.
 * Tha value of the cell can be update by either explicitly calling the proper set method (setValue())
 * or updating the possible values array. In this second case, the value is set when only one
 * possible value remains set to true.
 * Once the value has been set, in order to change the value again, it is necessary to call
 * the reset method, otherwise every attempt of doing the operation fires an exception.
 */
public final class Cell {

    private final static int VALUE_UNSET = -1;
    private final static String TAG = Cell.class.getSimpleName();

    private final int mRowIndex;
    private final int mColumnIndex;
    private final boolean [] mPossibleValues;
    private int mValue;

    //hide default constructor
    private Cell() {

        mRowIndex = VALUE_UNSET;
        mColumnIndex = VALUE_UNSET;
        mValue = VALUE_UNSET;
        mPossibleValues = null;
    }

    public Cell(final int rowIndex, final int columnIndex) throws ValueOutOfBoundsException {

        validateRowAndColumnIndex(rowIndex, columnIndex);

        this.mRowIndex = rowIndex;
        this.mColumnIndex = columnIndex;
        this.mValue = VALUE_UNSET;
        this.mPossibleValues = getInitializedPossibleValues();
    }

    public Cell(final int rowIndex, final int columnIndex, final int value) throws ValueOutOfBoundsException {

        validateRowAndColumnIndex(rowIndex, columnIndex);

        validateValue(value);

        this.mRowIndex = rowIndex;
        this.mColumnIndex = columnIndex;
        this.mValue = value;
        this.mPossibleValues = getInitializedPossibleValues();

        updatePossibleValues();
    }

    private static void validateValue(int value) throws ValueOutOfBoundsException {

        if (value < Sudoku.MIN_VALUE || value > Sudoku.MAX_VALUE) {

            throw new ValueOutOfBoundsException("'value' must be >= " + Sudoku.MIN_VALUE + "or <= " + Sudoku.MAX_VALUE);
        }
    }

    private static void validateRowAndColumnIndex(int rowIndex, int columnIndex) throws ValueOutOfBoundsException {

        if (rowIndex < Sudoku.MIN_VALUE - 1 || rowIndex >= Sudoku.MAX_VALUE) {

            throw new ValueOutOfBoundsException("'rowIndex' must be >= " + (Sudoku.MIN_VALUE - 1) + " 0 or < " + Sudoku.MAX_VALUE);
        }

        if (columnIndex < Sudoku.MIN_VALUE - 1 || columnIndex >= Sudoku.MAX_VALUE) {

            throw new ValueOutOfBoundsException("'columnIndex' must be >= " + (Sudoku.MIN_VALUE - 1) + " or < " + Sudoku.MAX_VALUE);
        }
    }

    private boolean[] getInitializedPossibleValues() {

        final boolean[] possibleValues = new boolean[Sudoku.MAX_VALUE];

        for (int i=0; i<possibleValues.length; i++) {

            possibleValues[i] = true;
        }

        return possibleValues;
    }

    //--------------------------------- GETTER ------------------------------------------------------

    public int getRowIndex() {
        return mRowIndex;
    }

    public int getColumnIndex() {
        return mColumnIndex;
    }

    public int getValue() {
        return mValue;
    }

    public boolean[] getPossibleValues() {
        return mPossibleValues;
    }

    public boolean hasValue() {
        return mValue != VALUE_UNSET;
    }

    //--------------------------------- SETTER ------------------------------------------------------------

    /**
     * Sets the value of the cell.
     * <p>
     * If the value of the cell has already been set, it is necessary call the method reset before attempting to call
     * this method, otherwise the method throws an sudoku.exception.OperationNotAllowedException
     */
    public void setValue(final int value) throws OperationNotAllowedException, ValueOutOfBoundsException {

        if (mValue != VALUE_UNSET) {

            throw new OperationNotAllowedException();
        }

        if (value < Sudoku.MIN_VALUE && value > Sudoku.MAX_VALUE) {

            throw new ValueOutOfBoundsException();
        }

        mValue = value;

        updatePossibleValues();
    }

    /**
     * @Precondition mValue != VALUE_UNSET
     */
    private void updatePossibleValues() {

        assert mValue != VALUE_UNSET;

        final int indexOfSetBit = mValue - 1;

        for (int i = 0; i < mPossibleValues.length; i++) {

            if (i == indexOfSetBit) {

                mPossibleValues[i] = true;
            } else {

                mPossibleValues[i] = false;
            }
        }
    }

    /**
     * Set one of the possible values of the cell.
     * <p>
     * If the value of the cell has already been set, it is necessary call the method reset before attempting to call
     * this method, otherwise the method throws an sudoku.exception.OperationNotAllowedException
     */
    public void setPossibleValue(final int value, final boolean allowed) throws InvalidParameterException, OperationNotAllowedException {

        if (mValue != VALUE_UNSET) {

            throw new OperationNotAllowedException();
        }

        if (value < Sudoku.MIN_VALUE && value > Sudoku.MAX_VALUE) {

            throw new InvalidParameterException();
        }

        final int index = value - 1;

        if (allowed) {

            mPossibleValues[index] = true;
        } else {

            mPossibleValues[index] = false;

            setValueIfPossible();
        }
    }

    private void setValueIfPossible() {

        int numberOfPossibleValues = 0;
        int indexOfSetValue = -1;
        for (int i = 0; i < mPossibleValues.length; i++) {

            if (mPossibleValues[i]) {

                numberOfPossibleValues++;
                indexOfSetValue = i;
            }
        }

        if (numberOfPossibleValues == 1) {

            mValue = indexOfSetValue + 1;

            Log.d(TAG, "Only one possible value, setting mValue to " + mValue);
        }
    }

    /**
     * Resets both the value and the possible values of the cell.
     */
    public void reset() {

        resetValue();

        resetPossibleValues();
    }

    /**
     * Resets the possible values of the cell
     */
    public void resetPossibleValues() {

        for (int i=0; i<mPossibleValues.length; i++) {

            mPossibleValues[i] = true;
        }
    }

    private void resetValue() {

        mValue = VALUE_UNSET;
    }

    public static String possibleValuesToString(final boolean[] possibleValues){

        String mex = "Possible Values: {";
        for (final boolean b : possibleValues) {
            mex += Boolean.toString(b) + ", ";
        }
        mex += "}";

        return mex;
    }
}

