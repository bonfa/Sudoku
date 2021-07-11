package sudoku.models;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    private final List<List<Cell>> zones;

    //TODO check invariant: number of rows = number of columns
    //TODO check invariant: number of rows in {1, 4, 6, 8, 9}
    public Grid(List<List<Cell>> zones) {
        this.zones = zones;
    }

    public Dimensions getDimensions() {
        return new Dimensions(zones.size(), zones.get(0).size());
    }

    public List<List<Cell>> getCells() {
        return zones;
    }

    public Zone squareBy(Position position) {
        return getSquares().get(getSquareNumber(zones, position.rowIndex, position.columnIndex));
    }

    public static int getSquareNumber(List<List<Cell>> zones, int i, int j) {
        switch (zones.size()) {
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

    private static int squareNumberForGridOfSizeOne() {
        return 0;
    }

    private static int squareNumberForGridOfSizeFour(int i, int j) {
        int n = 0;
        if ((i >= 0 && i < 2) && (j >= 0 && j < 2)) n = 0;
        else if ((i >= 0 && i < 2) && (j >= 2 && j < 4)) n = 1;
        else if ((i >= 2 && i < 4) && (j >= 0 && j < 2)) n = 2;
        else if ((i >= 2 && i < 4) && (j >= 2 && j < 4)) n = 3;
        return n;
    }

    private static int squareNumberForGridOfSizeSix(int i, int j) {
        int n = 0;
        if ((i >= 0 && i < 2) && (j >= 0 && j < 3)) n = 0;
        else if ((i >= 0 && i < 2) && (j >= 3 && j < 6)) n = 1;
        else if ((i >= 2 && i < 4) && (j >= 0 && j < 3)) n = 2;
        else if ((i >= 2 && i < 4) && (j >= 3 && j < 6)) n = 3;
        else if ((i >= 4 && i < 6) && (j >= 0 && j < 3)) n = 4;
        else if ((i >= 4 && i < 6) && (j >= 3 && j < 6)) n = 5;
        return n;
    }

    private static int squareNumberForGridOfSizeEight(int i, int j) {
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

    private static int squareNumberForNineSizeNine(int i, int j) {
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

    public List<Zone> getRows() {
        return zones.stream()
                    .map(Zone::new)
                    .collect(Collectors.toList());
    }

    public List<Zone> getColumns() {
        return IntStream.range(0, getRows().size())
                        .mapToObj(i -> new Zone(getRows().stream().map(l -> l.cells.get(i)).collect(Collectors.toList())))
                        .collect(Collectors.toList());
    }

    public Cell cellAt(Position position) {
        return getRows().get(position.rowIndex).cells.get(position.columnIndex);
    }

    /*
    INVARIANT: number of squares = number of rows = number of columns
    TODO: test for length != 9
     */
    //TODO make private and handle the test of the creation somehow

    public List<Zone> getSquares() {
        List<List<Cell>> squares = new ArrayList<>();
        for (int i = 0; i < zones.size(); i++) {
            squares.add(new ArrayList<>());
        }

        for (int i = 0; i < zones.size(); i++) {
            for (int j = 0; j < zones.get(i).size(); j++) {
                int n = getSquareNumber(zones, i, j);

                squares.get(n).add(getRows().get(i).cells.get(j));
            }
        }

        return squares.stream()
                      .map(Zone::new)
                      .collect(Collectors.toList());
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

    public static class Position {
        private final int rowIndex;
        private final int columnIndex;

        public Position(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public int getColumnIndex() {
            return columnIndex;
        }
    }
}
