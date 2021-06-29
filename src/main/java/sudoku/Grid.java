package sudoku;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static sudoku.utilities.Sets.*;

public class Grid {
    private final List<List<Cell>> sector;

    //TODO check invariant: number of rows = number of columns
    //TODO check invariant: number of rows in {1, 4, 6, 8, 9}
    public Grid(List<List<Cell>> sector) {
        this.sector = sector;
    }

    //TODO remove
    public static Set<Integer> valuesAlreadyPresent(List<Cell> sector) {
        return sector.stream().flatMap(c -> c.getValue().stream()).collect(Collectors.toSet());
    }

    public Dimensions getDimensions() {
        return new Dimensions(sector.size(), sector.get(0).size());
    }

    public List<List<Cell>> getCells() {
        return sector;
    }

    public Sector squareBy(int rowIndex, int columnIndex) {
        return getSquares().get(getSquareNumber(rowIndex, columnIndex));
    }

    public PossibleValues getPossibleValuesFor(Cell cell) {
        if (cell.getValue().isPresent()) {
            return new PossibleValues(cell, Collections.emptySet());
        }

        Set<Integer> valuesAlreadyPresentByRow = valuesAlreadyPresent(getRows().get(cell.getRowIndex()).cells);
        Set<Integer> valuesAlreadyPresentByColumn = valuesAlreadyPresent(getColumns().get(cell.getColumnIndex()).cells);
        Set<Integer> valuesAlreadyPresentBySquare = valuesAlreadyPresent(squareBy(cell.getRowIndex(), cell.getColumnIndex()).cells);

        Set<Integer> possibleValues = difference(allPossibleValues(),
                                                 sum(valuesAlreadyPresentByRow,
                                                     valuesAlreadyPresentByColumn,
                                                     valuesAlreadyPresentBySquare));

        return new PossibleValues(cell, possibleValues);
    }

    private int getSquareNumber(int i, int j) {
        switch (sector.size()) {
            case 1:
                return squareNumberForGridOfSizeOne();
            case 4:
                return squareNumberForGridOfSizeFour(i, j);
            case 6:
                return squareNumberForGridOfSizeSix(i, j);
            case 8:
                return squareNumberForGridOfSizeEight(i, j);
            case 9:
                return squareNumberForNineSizeNine(i, j);
        }
        return -1; //TODO
    }

    private int squareNumberForGridOfSizeOne() {
        return 0;
    }

    private int squareNumberForGridOfSizeFour(int i, int j) {
        int n = 0;
        if ((i >= 0 && i < 2) && (j >= 0 && j < 2)) n = 0;
        else if ((i >= 0 && i < 2) && (j >= 2 && j < 4)) n = 1;
        else if ((i >= 2 && i < 4) && (j >= 0 && j < 2)) n = 2;
        else if ((i >= 2 && i < 4) && (j >= 2 && j < 4)) n = 3;
        return n;
    }

    private int squareNumberForGridOfSizeSix(int i, int j) {
        int n = 0;
        if ((i >= 0 && i < 2) && (j >= 0 && j < 3)) n = 0;
        else if ((i >= 0 && i < 2) && (j >= 3 && j < 6)) n = 1;
        else if ((i >= 2 && i < 4) && (j >= 0 && j < 3)) n = 2;
        else if ((i >= 2 && i < 4) && (j >= 3 && j < 6)) n = 3;
        else if ((i >= 4 && i < 6) && (j >= 0 && j < 3)) n = 4;
        else if ((i >= 4 && i < 6) && (j >= 3 && j < 6)) n = 5;
        return n;
    }

    private int squareNumberForGridOfSizeEight(int i, int j) {
        int n = 0;
        if ((i >= 0 && i < 2) && (j >= 0 && j < 3)) n = 0;
        else if ((i >= 0 && i < 2) && (j >= 3 && j < 6)) n = 1;
        else if ((i >= 0 && i < 2) && (j >= 6 && j < 8)) n = 2;
        else if ((i >= 2 && i < 4) && (j >= 0 && j < 3)) n = 3;
        else if ((i >= 2 && i < 4) && (j >= 3 && j < 6)) n = 4;
        else if ((i >= 2 && i < 4) && (j >= 6 && j < 8)) n = 5;
        else if ((i >= 4 && i < 6) && (j >= 0 && j < 3)) n = 6;
        else if ((i >= 4 && i < 6) && (j >= 3 && j < 6)) n = 7;
        else if ((i >= 4 && i < 6) && (j >= 6 && j < 8)) n = 8;
        return n;
    }

    private int squareNumberForNineSizeNine(int i, int j) {
        int n = 0;
        if ((i >= 0 && i < 3) && (j >= 0 && j < 3)) n = 0;
        else if ((i >= 0 && i < 3) && (j >= 3 && j < 6)) n = 1;
        else if ((i >= 0 && i < 3) && (j >= 6 && j < 9)) n = 2;
        else if ((i >= 3 && i < 6) && (j >= 0 && j < 3)) n = 3;
        else if ((i >= 3 && i < 6) && (j >= 3 && j < 6)) n = 4;
        else if ((i >= 3 && i < 6) && (j >= 6 && j < 9)) n = 5;
        else if ((i >= 6 && i < 9) && (j >= 0 && j < 3)) n = 6;
        else if ((i >= 6 && i < 9) && (j >= 3 && j < 6)) n = 7;
        else if ((i >= 6 && i < 9) && (j >= 6 && j < 9)) n = 8;
        return n;
    }

    public List<Sector> getRows() {
        return sector.stream()
                    .map(Sector::new)
                    .collect(Collectors.toList());
    }

    public List<Sector> getColumns() {
        return IntStream.range(0, getRows().size())
                        .mapToObj(i -> new Sector(getRows().stream().map(l -> l.cells.get(i)).collect(Collectors.toList())))
                        .collect(Collectors.toList());
    }

    public Sector rowAt(Integer rowIndex) {
        return getRows().get(rowIndex);
    }

    public Sector columnAt(Integer columnIndex) {
        return getRows().get(columnIndex);
    }

    /*
    INVARIANT: number of squares = number of rows = number of columns
    TODO: test for length != 9
     */
    //TODO make private and handle the test of the creation somehow
    public List<Sector> getSquares() {
        List<List<Cell>> squares = new ArrayList<>();
        for (int i = 0; i < sector.size(); i++) {
            squares.add(new ArrayList<>());
        }

        for (int i = 0; i < sector.size(); i++) {
            for (int j = 0; j < sector.get(i).size(); j++) {
                int n = getSquareNumber(i, j);

                squares.get(n).add(getRows().get(i).cells.get(j));
            }
        }

        return squares.stream()
                      .map(Sector::new)
                      .collect(Collectors.toList());
    }

    public Set<Integer> allPossibleValues() {
        return IntStream.rangeClosed(1, sector.size()).boxed().collect(Collectors.toSet());
    }

    public static class PossibleValues {


        private final Cell cell;
        private final Set<Integer> possibleValues;

        public PossibleValues(Cell cell, Set<Integer> possibleValues) {
            this.cell = cell;
            this.possibleValues = possibleValues;
        }


        public Cell getCell() {
            return cell;
        }

        public Set<Integer> getPossibleValues() {
            return possibleValues;
        }
    }

    public static class Dimensions {
        public final int rows;
        public final int columns;

        private Dimensions(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dimensions that = (Dimensions) o;
            return rows == that.rows && columns == that.columns;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
