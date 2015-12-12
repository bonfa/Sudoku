package sudoku;

import org.junit.Test;
import sudoku.exception.OperationNotAllowedException;
import sudoku.exception.ValueOutOfBoundsException;

import java.lang.reflect.Field;

/**
 * Created by bonfa on 05/10/15.
 *
 */
public class CellTest {

    //------------------------------ Row/Column Index out of bound in constructor --------------------

    @Test(expected = ValueOutOfBoundsException.class)
    public void testCellErrorRowIndexLowerThanExpected() throws ValueOutOfBoundsException {

        new Cell(-1, 5);
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void testCellErrorRowIndexHigherThanExpected() throws ValueOutOfBoundsException {

        new Cell(9, 5);
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void testCellErrorColumnIndexLowerThanExpected() throws ValueOutOfBoundsException {

        new Cell(4, -1);
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void testCellErrorColumnIndexHigherThanExpected() throws ValueOutOfBoundsException {

        new Cell(4, 9);
    }

    //---------------------------------- Value out of bounds in constructor ---------------------------

    @Test(expected = ValueOutOfBoundsException.class)
    public void testCellValueMuchLowerThanExpected() throws ValueOutOfBoundsException {

        new Cell(4, 5, -1);
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void testCellValueLowerThanExpected() throws ValueOutOfBoundsException {

        new Cell(4, 5, 0);
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void testCellValueMuchHigherThanExpected() throws ValueOutOfBoundsException {

        new Cell(4, 5, 10);
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void testCellValueHigherThanExpected() throws ValueOutOfBoundsException {

        new Cell(4, 5, 11);
    }

    //---------------------------------- Constructors ok -------------------------------

    @Test()
    public void testCellIndexesLowerBound() throws ValueOutOfBoundsException, NoSuchFieldException, IllegalAccessException {

        final int rowIndex = 0;
        final int columnIndex = 0;

        final Cell cell = new Cell(rowIndex, columnIndex);

        final Field field = cell.getClass().getDeclaredField("VALUE_UNSET");
        field.setAccessible(true);

        assert (cell.getRowIndex() == rowIndex);
        assert (cell.getColumnIndex() == columnIndex);
        assert (cell.hasValue() == false);
        assert (cell.getValue() == (Integer)field.get(cell));
        assert (cell.getPossibleValues() != null);
        assert (cell.getPossibleValues().length == Sudoku.MAX_VALUE);
        assert (cell.getPossibleValues()[0] == true);
        assert (cell.getPossibleValues()[1] == true);
        assert (cell.getPossibleValues()[2] == true);
        assert (cell.getPossibleValues()[3] == true);
        assert (cell.getPossibleValues()[4] == true);
        assert (cell.getPossibleValues()[5] == true);
        assert (cell.getPossibleValues()[6] == true);
        assert (cell.getPossibleValues()[7] == true);
        assert (cell.getPossibleValues()[8] == true);
    }

    @Test()
    public void testCellIndexesUpperBound() throws ValueOutOfBoundsException, NoSuchFieldException, IllegalAccessException {

        final int rowIndex = 8;
        final int columnIndex = 8;

        final Cell cell = new Cell(rowIndex, columnIndex);

        final Field field = cell.getClass().getDeclaredField("VALUE_UNSET");
        field.setAccessible(true);

        assert (cell.getRowIndex() == rowIndex);
        assert (cell.getColumnIndex() == columnIndex);
        assert (cell.hasValue() == false);
        assert (cell.getValue() == (Integer)field.get(cell));
        assert (cell.getPossibleValues() != null);
        assert (cell.getPossibleValues().length == Sudoku.MAX_VALUE);
        assert (cell.getPossibleValues()[0] == true);
        assert (cell.getPossibleValues()[1] == true);
        assert (cell.getPossibleValues()[2] == true);
        assert (cell.getPossibleValues()[3] == true);
        assert (cell.getPossibleValues()[4] == true);
        assert (cell.getPossibleValues()[5] == true);
        assert (cell.getPossibleValues()[6] == true);
        assert (cell.getPossibleValues()[7] == true);
        assert (cell.getPossibleValues()[8] == true);
    }

    @Test()
    public void testCellIndexesMiddle() throws ValueOutOfBoundsException, NoSuchFieldException, IllegalAccessException {

        final int rowIndex = 4;
        final int columnIndex = 5;

        final Cell cell = new Cell(rowIndex, columnIndex);

        final Field field = cell.getClass().getDeclaredField("VALUE_UNSET");
        field.setAccessible(true);

        assert (cell.getRowIndex() == rowIndex);
        assert (cell.getColumnIndex() == columnIndex);
        assert (cell.hasValue() == false);
        assert (cell.getValue() == (Integer)field.get(cell));
        assert (cell.getPossibleValues() != null);
        assert (cell.getPossibleValues().length == Sudoku.MAX_VALUE);
        assert (cell.getPossibleValues()[0] == true);
        assert (cell.getPossibleValues()[1] == true);
        assert (cell.getPossibleValues()[2] == true);
        assert (cell.getPossibleValues()[3] == true);
        assert (cell.getPossibleValues()[4] == true);
        assert (cell.getPossibleValues()[5] == true);
        assert (cell.getPossibleValues()[6] == true);
        assert (cell.getPossibleValues()[7] == true);
        assert (cell.getPossibleValues()[8] == true);
    }

    @Test()
    public void testCellValueMinAcceptableValue() throws ValueOutOfBoundsException, NoSuchFieldException {

        final int rowIndex = 4;
        final int columnIndex = 5;
        final int value = 1;

        final Cell cell = new Cell(rowIndex, columnIndex, value);

        assert (cell.getRowIndex() == rowIndex);
        assert (cell.getColumnIndex() == columnIndex);
        assert (cell.hasValue() == true);
        assert (cell.getValue() == value);
        assert (cell.getPossibleValues() != null);
        assert (cell.getPossibleValues().length == Sudoku.MAX_VALUE);
        assert (cell.getPossibleValues()[0] == true);
        assert (cell.getPossibleValues()[1] == false);
        assert (cell.getPossibleValues()[2] == false);
        assert (cell.getPossibleValues()[3] == false);
        assert (cell.getPossibleValues()[4] == false);
        assert (cell.getPossibleValues()[5] == false);
        assert (cell.getPossibleValues()[6] == false);
        assert (cell.getPossibleValues()[7] == false);
        assert (cell.getPossibleValues()[8] == false);
    }

    @Test()
    public void testCellValueMaxAcceptableValue() throws ValueOutOfBoundsException {

        final int rowIndex = 5;
        final int columnIndex = 6;
        final int value = 9;

        final Cell cell = new Cell(rowIndex, columnIndex, value);

        assert (cell.getRowIndex() == rowIndex);
        assert (cell.getColumnIndex() == columnIndex);
        assert (cell.hasValue() == true);
        assert (cell.getValue() == value);
        assert (cell.getPossibleValues() != null);
        assert (cell.getPossibleValues().length == Sudoku.MAX_VALUE);
        assert (cell.getPossibleValues()[0] == false);
        assert (cell.getPossibleValues()[1] == false);
        assert (cell.getPossibleValues()[2] == false);
        assert (cell.getPossibleValues()[3] == false);
        assert (cell.getPossibleValues()[4] == false);
        assert (cell.getPossibleValues()[5] == false);
        assert (cell.getPossibleValues()[6] == false);
        assert (cell.getPossibleValues()[7] == false);
        assert (cell.getPossibleValues()[8] == true);
    }

    @Test()
    public void testCellValueMiddle() throws ValueOutOfBoundsException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;

        final Cell cell = new Cell(rowIndex, columnIndex, value);

        assert (cell.getRowIndex() == rowIndex);
        assert (cell.getColumnIndex() == columnIndex);
        assert (cell.hasValue() == true);
        assert (cell.getValue() == value);
        assert (cell.getPossibleValues() != null);
        assert (cell.getPossibleValues().length == Sudoku.MAX_VALUE);
        assert (cell.getPossibleValues()[0] == false);
        assert (cell.getPossibleValues()[1] == false);
        assert (cell.getPossibleValues()[2] == false);
        assert (cell.getPossibleValues()[3] == true);
        assert (cell.getPossibleValues()[4] == false);
        assert (cell.getPossibleValues()[5] == false);
        assert (cell.getPossibleValues()[6] == false);
        assert (cell.getPossibleValues()[7] == false);
        assert (cell.getPossibleValues()[8] == false);
    }

    //---------------------------------- Operations -------------------------------

    @Test(expected = OperationNotAllowedException.class)
    public void testCellWriteAlreadyDefinedValueWithoutReset() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;

        final Cell cell = new Cell(rowIndex, columnIndex, value);
        cell.setValue(3);
    }

    @Test()
    public void testCellReset() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;

        final Cell cell = new Cell(rowIndex, columnIndex, value);
        cell.reset();
        assert (cell.hasValue() == false);
        assert (cell.getPossibleValues().length == Sudoku.MAX_VALUE);
        assert (cell.getPossibleValues()[0] == true);
        assert (cell.getPossibleValues()[1] == true);
        assert (cell.getPossibleValues()[2] == true);
        assert (cell.getPossibleValues()[3] == true);
        assert (cell.getPossibleValues()[4] == true);
        assert (cell.getPossibleValues()[5] == true);
        assert (cell.getPossibleValues()[6] == true);
        assert (cell.getPossibleValues()[7] == true);
        assert (cell.getPossibleValues()[8] == true);
    }

    @Test()
    public void testCellWriteAndReset() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;

        final Cell cell = new Cell(rowIndex, columnIndex, value);
        cell.reset();
        cell.setValue(5);
        assert (cell.hasValue() == true);
        assert (cell.getPossibleValues().length == Sudoku.MAX_VALUE);
        assert (cell.getPossibleValues()[0] == false);
        assert (cell.getPossibleValues()[1] == false);
        assert (cell.getPossibleValues()[2] == false);
        assert (cell.getPossibleValues()[3] == false);
        assert (cell.getPossibleValues()[4] == true);
        assert (cell.getPossibleValues()[5] == false);
        assert (cell.getPossibleValues()[6] == false);
        assert (cell.getPossibleValues()[7] == false);
        assert (cell.getPossibleValues()[8] == false);
    }
}