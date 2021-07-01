package old.sudoku;

import org.junit.jupiter.api.Test;
import old.sudoku.exception.OperationNotAllowedException;
import old.sudoku.exception.ValueOutOfBoundsException;

import java.lang.reflect.Field;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bonfa on 05/10/15.
 */
public class CellTest {

    //------------------------------ Row/Column Index out of bound in constructor --------------------

    @Test
    public void testCellErrorRowIndexLowerThanExpected() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Cell(-1, 5));
    }

    @Test
    public void testCellErrorRowIndexHigherThanExpected() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Cell(9, 5));
    }

    @Test
    public void testCellErrorColumnIndexLowerThanExpected() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Cell(4, -1));
    }

    @Test
    public void testCellErrorColumnIndexHigherThanExpected() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Cell(4, 9));
    }

    //---------------------------------- Value out of bounds in constructor ---------------------------

    @Test
    public void testCellValueMuchLowerThanExpected() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Cell(4, 5, -1));
    }

    @Test
    public void testCellValueLowerThanExpected() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Cell(4, 5, 0));
    }

    @Test
    public void testCellValueMuchHigherThanExpected() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Cell(4, 5, 10));
    }

    @Test
    public void testCellValueHigherThanExpected() {

        assertThrows(ValueOutOfBoundsException.class, () -> new Cell(4, 5, 11));
    }

    //---------------------------------- Constructors ok -------------------------------

    @Test()
    public void testCellIndexesLowerBound() throws ValueOutOfBoundsException, NoSuchFieldException, IllegalAccessException {

        final int rowIndex = 0;
        final int columnIndex = 0;

        final Cell cell = new Cell(rowIndex, columnIndex);

        final Field field = cell.getClass().getDeclaredField("VALUE_UNSET");
        field.setAccessible(true);

        assertEquals (cell.getRowIndex(), rowIndex);
        assertEquals (cell.getColumnIndex(), columnIndex);
        assertFalse(cell.hasValue());
        assertEquals (cell.getValue(), (Integer) field.get(cell));
        assertNotNull (cell.getCandidates());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertTrue(cell.getCandidates()[0]);
        assertTrue(cell.getCandidates()[1]);
        assertTrue(cell.getCandidates()[2]);
        assertTrue(cell.getCandidates()[3]);
        assertTrue(cell.getCandidates()[4]);
        assertTrue(cell.getCandidates()[5]);
        assertTrue(cell.getCandidates()[6]);
        assertTrue(cell.getCandidates()[7]);
        assertTrue(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 9);
    }

    @Test()
    public void testCellIndexesUpperBound() throws ValueOutOfBoundsException, NoSuchFieldException, IllegalAccessException {

        final int rowIndex = 8;
        final int columnIndex = 8;

        final Cell cell = new Cell(rowIndex, columnIndex);

        final Field field = cell.getClass().getDeclaredField("VALUE_UNSET");
        field.setAccessible(true);

        assertEquals (cell.getRowIndex(), rowIndex);
        assertEquals (cell.getColumnIndex(), columnIndex);
        assertFalse(cell.hasValue());
        assertEquals (cell.getValue(), (Integer) field.get(cell));
        assertNotNull(cell.getCandidates());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertTrue(cell.getCandidates()[0]);
        assertTrue(cell.getCandidates()[1]);
        assertTrue(cell.getCandidates()[2]);
        assertTrue(cell.getCandidates()[3]);
        assertTrue(cell.getCandidates()[4]);
        assertTrue(cell.getCandidates()[5]);
        assertTrue(cell.getCandidates()[6]);
        assertTrue(cell.getCandidates()[7]);
        assertTrue(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 9);
    }

    @Test()
    public void testCellIndexesMiddle() throws ValueOutOfBoundsException, NoSuchFieldException, IllegalAccessException {

        final int rowIndex = 4;
        final int columnIndex = 5;

        final Cell cell = new Cell(rowIndex, columnIndex);

        final Field field = cell.getClass().getDeclaredField("VALUE_UNSET");
        field.setAccessible(true);

        assertEquals (cell.getRowIndex(), rowIndex);
        assertEquals (cell.getColumnIndex(), columnIndex);
        assertFalse(cell.hasValue());
        assertEquals (cell.getValue(), (Integer) field.get(cell));
        assertNotNull (cell.getCandidates());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertTrue(cell.getCandidates()[0]);
        assertTrue(cell.getCandidates()[1]);
        assertTrue(cell.getCandidates()[2]);
        assertTrue(cell.getCandidates()[3]);
        assertTrue(cell.getCandidates()[4]);
        assertTrue(cell.getCandidates()[5]);
        assertTrue(cell.getCandidates()[6]);
        assertTrue(cell.getCandidates()[7]);
        assertTrue(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 9);
    }

    @Test()
    public void testCellValueMinAcceptableValue() throws ValueOutOfBoundsException {

        final int rowIndex = 4;
        final int columnIndex = 5;
        final int value = 1;

        final Cell cell = new Cell(rowIndex, columnIndex, value);

        assertEquals (cell.getRowIndex(), rowIndex);
        assertEquals (cell.getColumnIndex(), columnIndex);
        assertTrue(cell.hasValue());
        assertEquals (cell.getValue(), value);
        assertNotNull (cell.getCandidates());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertTrue(cell.getCandidates()[0]);
        assertFalse(cell.getCandidates()[1]);
        assertFalse(cell.getCandidates()[2]);
        assertFalse(cell.getCandidates()[3]);
        assertFalse(cell.getCandidates()[4]);
        assertFalse(cell.getCandidates()[5]);
        assertFalse(cell.getCandidates()[6]);
        assertFalse(cell.getCandidates()[7]);
        assertFalse(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 1);
    }

    @Test()
    public void testCellValueMaxAcceptableValue() throws ValueOutOfBoundsException {

        final int rowIndex = 5;
        final int columnIndex = 6;
        final int value = 9;

        final Cell cell = new Cell(rowIndex, columnIndex, value);

        assertEquals (cell.getRowIndex(), rowIndex);
        assertEquals (cell.getColumnIndex(), columnIndex);
        assertTrue(cell.hasValue());
        assertEquals (cell.getValue(), value);
        assertNotNull (cell.getCandidates());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertFalse(cell.getCandidates()[0]);
        assertFalse(cell.getCandidates()[1]);
        assertFalse(cell.getCandidates()[2]);
        assertFalse(cell.getCandidates()[3]);
        assertFalse(cell.getCandidates()[4]);
        assertFalse(cell.getCandidates()[5]);
        assertFalse(cell.getCandidates()[6]);
        assertFalse(cell.getCandidates()[7]);
        assertTrue(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 1);
    }

    @Test()
    public void testCellValueMiddle() throws ValueOutOfBoundsException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;

        final Cell cell = new Cell(rowIndex, columnIndex, value);

        assertEquals (cell.getRowIndex(), rowIndex);
        assertEquals (cell.getColumnIndex(), columnIndex);
        assertTrue(cell.hasValue());
        assertEquals (cell.getValue(), value);
        assertNotNull (cell.getCandidates());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertFalse(cell.getCandidates()[0]);
        assertFalse(cell.getCandidates()[1]);
        assertFalse(cell.getCandidates()[2]);
        assertTrue(cell.getCandidates()[3]);
        assertFalse(cell.getCandidates()[4]);
        assertFalse(cell.getCandidates()[5]);
        assertFalse(cell.getCandidates()[6]);
        assertFalse(cell.getCandidates()[7]);
        assertFalse(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 1);
    }

    //---------------------------------- getPossibleValues -------------------------------

    @Test
    public void testCellWriteAlreadyDefinedValueWithoutReset() throws ValueOutOfBoundsException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;

        final Cell cell = new Cell(rowIndex, columnIndex, value);

        assertThrows(OperationNotAllowedException.class, () -> cell.setValue(3));
    }

    @Test()
    public void testCellReset() throws ValueOutOfBoundsException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;

        final Cell cell = new Cell(rowIndex, columnIndex, value);
        cell.reset();

        assertFalse(cell.hasValue());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertTrue(cell.getCandidates()[0]);
        assertTrue(cell.getCandidates()[1]);
        assertTrue(cell.getCandidates()[2]);
        assertTrue(cell.getCandidates()[3]);
        assertTrue(cell.getCandidates()[4]);
        assertTrue(cell.getCandidates()[5]);
        assertTrue(cell.getCandidates()[6]);
        assertTrue(cell.getCandidates()[7]);
        assertTrue(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 9);
    }

    @Test()
    public void testCellWriteAndReset() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;

        final Cell cell = new Cell(rowIndex, columnIndex, value);
        cell.reset();
        cell.setValue(5);

        assertTrue(cell.hasValue());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertFalse(cell.getCandidates()[0]);
        assertFalse(cell.getCandidates()[1]);
        assertFalse(cell.getCandidates()[2]);
        assertFalse(cell.getCandidates()[3]);
        assertTrue(cell.getCandidates()[4]);
        assertFalse(cell.getCandidates()[5]);
        assertFalse(cell.getCandidates()[6]);
        assertFalse(cell.getCandidates()[7]);
        assertFalse(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 1);
    }

    @Test()
    public void testCellUpdatePossibleValues() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;

        final Cell cell = new Cell(rowIndex, columnIndex);
        cell.setPossibleValue(2, false);
        cell.setPossibleValue(3, false);

        assertFalse(cell.hasValue());
        assertEquals (cell.getCandidates().length, Sudoku.MAX_VALUE);
        assertTrue(cell.getCandidates()[0]);
        assertFalse(cell.getCandidates()[1]);
        assertFalse(cell.getCandidates()[2]);
        assertTrue(cell.getCandidates()[3]);
        assertTrue(cell.getCandidates()[4]);
        assertTrue(cell.getCandidates()[5]);
        assertTrue(cell.getCandidates()[6]);
        assertTrue(cell.getCandidates()[7]);
        assertTrue(cell.getCandidates()[8]);
        assertEquals (cell.getNumberOfPossibleValues(), 7);
    }

    @Test()
    public void testCellGetFirstPossibleValueNotPresent() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;

        final Cell cell = new Cell(rowIndex, columnIndex);
        cell.setPossibleValue(1, false);
        cell.setPossibleValue(2, false);
        cell.setPossibleValue(3, false);
        cell.setPossibleValue(4, false);
        cell.setPossibleValue(5, false);
        cell.setPossibleValue(6, false);
        cell.setPossibleValue(7, false);
        cell.setPossibleValue(8, false);
        cell.setPossibleValue(9, false);

        assertEquals (cell.getFirstPossibleValue(), Cell.NO_POSSIBLE_VALUES);
    }

    @Test()
    public void testCellGetFirstPossibleValueOnlyOnePresent() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;

        final Cell cell = new Cell(rowIndex, columnIndex);
        cell.setPossibleValue(1, false);
        cell.setPossibleValue(2, false);
        cell.setPossibleValue(3, false);
        cell.setPossibleValue(4, true);
        cell.setPossibleValue(5, false);
        cell.setPossibleValue(6, false);
        cell.setPossibleValue(7, false);
        cell.setPossibleValue(8, false);
        cell.setPossibleValue(9, false);

        assertEquals (cell.getFirstPossibleValue(), 4);
    }

    @Test()
    public void testCellGetFirstPossibleValueManyPresent() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;

        final Cell cell = new Cell(rowIndex, columnIndex);
        cell.setPossibleValue(1, false);
        cell.setPossibleValue(2, true);
        cell.setPossibleValue(3, false);
        cell.setPossibleValue(4, true);
        cell.setPossibleValue(5, false);
        cell.setPossibleValue(6, true);
        cell.setPossibleValue(7, false);
        cell.setPossibleValue(8, false);
        cell.setPossibleValue(9, false);

        assertEquals (cell.getFirstPossibleValue(), 2);
    }

    //---------------------------------- Constructor for cloning -------------------------------

    @Test()
    public void testCloneConstructorNoValue() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final Cell cell = new Cell(rowIndex, columnIndex);

        final Cell copy = new Cell(cell);

        assertNotEquals (cell, copy);
        assertEquals (cell.getColumnIndex(), copy.getColumnIndex());
        assertEquals (cell.getRowIndex(), copy.getRowIndex());
        assertEquals (cell.getValue(), copy.getValue());
        assertNotEquals (cell.getCandidates(), copy.getCandidates());
        assertTrue (Objects.deepEquals(cell.getCandidates(), copy.getCandidates()));

        cell.setValue(5);

        assertNotEquals (cell.getValue(), copy.getValue());
        assertNotEquals (cell.getCandidates(), copy.getCandidates());
        assertFalse (Objects.deepEquals(cell.getCandidates(), copy.getCandidates()));

        copy.setValue(5);
        assertNotEquals (cell.getCandidates(), copy.getCandidates());
        assertTrue (Objects.deepEquals(cell.getCandidates(), copy.getCandidates()));
    }

    @Test()
    public void testCloneConstructor() throws ValueOutOfBoundsException, OperationNotAllowedException {

        final int rowIndex = 3;
        final int columnIndex = 8;
        final int value = 4;
        final Cell cell = new Cell(rowIndex, columnIndex, value);
        final Cell copy = new Cell(cell);

        assertNotEquals (cell, copy);
        assertEquals (cell.getColumnIndex(), copy.getColumnIndex());
        assertEquals (cell.getRowIndex(), copy.getRowIndex());
        assertEquals (cell.getValue(), copy.getValue());
        assertTrue (Objects.deepEquals(cell.getCandidates(), copy.getCandidates()));

        cell.reset();

        assertEquals (cell.getColumnIndex(), copy.getColumnIndex());
        assertEquals (cell.getRowIndex(), copy.getRowIndex());
        assertNotEquals (cell.getValue(), copy.getValue());
        assertNotEquals (cell.getCandidates(), copy.getCandidates());
        assertFalse (Objects.deepEquals(cell.getCandidates(), copy.getCandidates()));

        cell.setValue(5);

        assertNotEquals (cell.getValue(), copy.getValue());
        assertFalse (Objects.deepEquals(cell.getCandidates(), copy.getCandidates()));

        cell.reset();
        cell.setValue(4);

        assertEquals (cell.getColumnIndex(), copy.getColumnIndex());
        assertEquals (cell.getRowIndex(), copy.getRowIndex());
        assertEquals (cell.getValue(), copy.getValue());
        assertNotEquals (cell.getCandidates(), copy.getCandidates());
        assertTrue (Objects.deepEquals(cell.getCandidates(), copy.getCandidates()));
    }
}