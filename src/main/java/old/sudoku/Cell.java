package old.sudoku;

import old.sudoku.exception.OperationNotAllowedException;
import old.sudoku.exception.ValueOutOfBoundsException;

import java.security.InvalidParameterException;

/**
 * Created by bonfa on 07/12/15.
 * <p>
 * This is the building block of the old.sudoku. It represents a single cell of the old.sudoku.
 * As such, it has a row index, a column index, a value and a set of the possible values.
 * The index of the row and the column in the matrix of the old.sudoku are immutable and can
 * be defined only at construction time. The value and the possible values, instead, can be updated
 * after the cell has been created.
 * Tha value of the cell can be update by either explicitly calling the proper set method (setValue())
 * or updating the possible values array. In this second case, the value is set when only one
 * possible value remains set to true.
 * Once the value has been set, in order to change the value again, it is necessary to call
 * the reset method, otherwise every attempt of doing the operation fires an exception.
 */
public final class Cell {

    public final static int NO_POSSIBLE_VALUES = -1;
    private final static int VALUE_UNSET = -1;
    private final static String TAG = Cell.class.getSimpleName();

    private final int mRowIndex;
    private final int mColumnIndex;
    private final boolean[] mPossibleValues;
    private int mValue;

    //hide default constructor
    private Cell() {

        mRowIndex = VALUE_UNSET;
        mColumnIndex = VALUE_UNSET;
        mValue = VALUE_UNSET;
        mPossibleValues = null;
    }

    /**
     * Constructor
     *
     * @param rowIndex    the index of the row of the cell
     * @param columnIndex the index of the column of the cell
     * @throws ValueOutOfBoundsException
     */
    public Cell(final int rowIndex, final int columnIndex) throws ValueOutOfBoundsException {

        validateRowAndColumnIndex(rowIndex, columnIndex);

        this.mRowIndex = rowIndex;
        this.mColumnIndex = columnIndex;
        this.mValue = VALUE_UNSET;
        this.mPossibleValues = getInitializedPossibleValues();
    }

    /**
     * Constructor
     *
     * @param rowIndex    the index of the row of the cell
     * @param columnIndex the index of the column of the cell
     * @param value       the value of the cell
     * @throws ValueOutOfBoundsException
     */
    public Cell(final int rowIndex, final int columnIndex, final int value) throws ValueOutOfBoundsException {

        validateRowAndColumnIndex(rowIndex, columnIndex);

        validateValue(value);

        this.mRowIndex = rowIndex;
        this.mColumnIndex = columnIndex;
        this.mValue = value;
        this.mPossibleValues = getInitializedPossibleValues();

        updatePossibleValues();
    }

    /**
     * Constructor
     *
     * @param cell the cell to copy
     */
    public Cell(final Cell cell) {

        mRowIndex = cell.getRowIndex();
        mColumnIndex = cell.getColumnIndex();
        mValue = cell.getValue();
        mPossibleValues = getInitializedPossibleValues();
        System.arraycopy(cell.getCandidates(), 0, mPossibleValues, 0, cell.getCandidates().length);

    }

    /**
     * Checks that the value is >= than {@see MIN_VALUE} and >= {@see MAX_VALUE}
     *
     * @param value the value of the cell
     * @throws ValueOutOfBoundsException
     */
    private static void validateValue(final int value) throws ValueOutOfBoundsException {

        if (value < Sudoku.MIN_VALUE || value > Sudoku.MAX_VALUE) {

            throw new ValueOutOfBoundsException("'value' must be >= " + Sudoku.MIN_VALUE + "or <= " + Sudoku.MAX_VALUE);
        }
    }

    /**
     * Checks that the row and the column index of the cell are >= {@see MIN_VALUE} - 1 and <= {@see MAX_VALUE} - 1
     *
     * @param rowIndex    the index of the row of the cell
     * @param columnIndex the index of the column of the cell
     * @throws ValueOutOfBoundsException
     */
    private static void validateRowAndColumnIndex(final int rowIndex, final int columnIndex) throws ValueOutOfBoundsException {

        if (rowIndex < Sudoku.MIN_VALUE - 1 || rowIndex >= Sudoku.MAX_VALUE) {

            throw new ValueOutOfBoundsException("'rowIndex' must be >= " + (Sudoku.MIN_VALUE - 1) + " 0 or < " + Sudoku.MAX_VALUE);
        }

        if (columnIndex < Sudoku.MIN_VALUE - 1 || columnIndex >= Sudoku.MAX_VALUE) {

            throw new ValueOutOfBoundsException("'columnIndex' must be >= " + (Sudoku.MIN_VALUE - 1) + " or < " + Sudoku.MAX_VALUE);
        }
    }

    /**
     * Initializes the possible values array of the cell to an array of all true values
     *
     * @return the possible values array in the initial state
     */
    private boolean[] getInitializedPossibleValues() {

        final boolean[] possibleValues = new boolean[Sudoku.MAX_VALUE];

        for (int i = 0; i < possibleValues.length; i++) {

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

    public boolean[] getCandidates() {
        return mPossibleValues;
    }

    public boolean hasValue() {
        return mValue != VALUE_UNSET;
    }

    //--------------------------------- SETTER ------------------------------------------------------------

    /**
     * sudoku.impl.utilities.Sets the value of the cell.
     * <p>
     * If the value of the cell has already been set, it is necessary to call the method {@see #reset()} before
     * attempting to call this method, otherwise the method throws an {@see OperationNotAllowedException}
     */
    public void setValue(final int value) throws OperationNotAllowedException, ValueOutOfBoundsException {

        if (mValue != VALUE_UNSET) {

            throw new OperationNotAllowedException("trying to set an already set variable - cell [" + mRowIndex + "][" + mColumnIndex + "]");
        }

        if (value < Sudoku.MIN_VALUE && value > Sudoku.MAX_VALUE) {

            throw new ValueOutOfBoundsException();
        }

        mValue = value;

        updatePossibleValues();
    }

    /**
     * Updates the possible values array of a set cell, that is sets to false all the value except the one which
     * represents the value of the cell
     *
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
     * this method, otherwise the method throws an old.sudoku.exception.OperationNotAllowedException
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

        }
    }

    /**
     * If the array of the possible values contains only one value set to 'true', sets the value of the cell to the
     * suggested by the possible values array
     */
//    private void setValueIfPossible() {
//
//        int numberOfPossibleValues = 0;
//        int indexOfSetValue = -1;
//        for (int i = 0; i < mPossibleValues.length; i++) {
//
//            if (mPossibleValues[i]) {
//
//                numberOfPossibleValues++;
//                indexOfSetValue = i;
//            }
//        }
//
//        if (numberOfPossibleValues == 1) {
//
//            mValue = indexOfSetValue + 1;
//
//            Log.d(TAG, "Only one possible value, setting mValue to " + mValue);
//        }
//    }

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

        for (int i = 0; i < mPossibleValues.length; i++) {

            mPossibleValues[i] = true;
        }
    }

    /**
     * Resets the value of the cell
     */
    private void resetValue() {

        mValue = VALUE_UNSET;
    }

    /**
     * Returns the number of possible values
     *
     * @return the number of possible values
     */
    public int getNumberOfPossibleValues() {

        int numberOfTrueValues = 0;
        for (final boolean possibleValue : mPossibleValues) {

            if (possibleValue) {
                numberOfTrueValues++;
            }
        }
        return numberOfTrueValues;
    }

    /**
     * Returns the first possible value, if present, -1 otherwise
     *
     * @return the number of possible values
     */
    public int getFirstPossibleValue() {

        for (int i = 0; i < mPossibleValues.length; i++) {

            if (mPossibleValues[i]) {

                return i + 1;
            }
        }

        return NO_POSSIBLE_VALUES;
    }

    /**
     * Gives a fast string representation of the possible values
     *
     * @param possibleValues the possible values of the cell
     * @return a string representation of the possible values
     */
    public static String possibleValuesToString(final boolean[] possibleValues) {

        String mex = "Possible Values: {";
        for (final boolean b : possibleValues) {
            mex += Boolean.toString(b) + ", ";
        }
        mex += "}";

        return mex;
    }

    //TODO make equals method
}

