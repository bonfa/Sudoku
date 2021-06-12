package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    private final List<List<Cell>> cells;

    //TODO check invariant: number of rows = number of columns
    //TODO check invariant: number of rows in {1, 4, 6, 8, 9}
    public Grid(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public List<Cells> getRows() {
        return cells.stream()
                    .map(Cells::new)
                    .collect(Collectors.toList());
    }

    public List<Cells> getColumns() {
        return IntStream.range(0, getRows().size())
                        .mapToObj(i -> new Cells(getRows().stream().map(l -> l.getCells().get(i)).collect(Collectors.toList())))
                        .collect(Collectors.toList());
    }

    /*
    INVARIANT: number of squares = number of rows = number of columns
    TODO: test for length != 9
     */
    public List<Cells> getSquares() {
        List<List<Cell>> squares = new ArrayList<>();
        for (int i = 0; i < cells.size(); i++) {
            squares.add(new ArrayList<>());
        }

        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                int n = getSquareNumber(i, j);

                squares.get(n).add(getRows().get(i).getCells().get(j));
            }
        }

        return squares.stream()
                      .map(Cells::new)
                      .collect(Collectors.toList());
    }

    private int getSquareNumber(int i, int j) {
        switch (cells.size()) {
            case 1: return squareNumberForGridOfSizeOne();
            case 4: return squareNumberForGridOfSizeFour(i, j);
            case 6: return squareNumberForGridOfSizeSix(i, j);
            case 8: return squareNumberForGridOfSizeEight(i, j);
            case 9: return squareNumberForNineSizeNine(i, j);
        }
        return -1; //TODO
    }

    private int squareNumberForGridOfSizeOne() {
        return 0;
    }

    private int squareNumberForGridOfSizeFour(int i, int j) {
        int n = 0;
        if      ((i >= 0 && i < 2) && (j >= 0 && j < 2)) n = 0;
        else if ((i >= 0 && i < 2) && (j >= 2 && j < 4)) n = 1;
        else if ((i >= 2 && i < 4) && (j >= 0 && j < 2)) n = 2;
        else if ((i >= 2 && i < 4) && (j >= 2 && j < 4)) n = 3;
        return n;
    }

    private int squareNumberForGridOfSizeSix(int i, int j) {
        int n = 0;
        if      ((i >= 0 && i < 2) && (j >= 0 && j < 3)) n = 0;
        else if ((i >= 0 && i < 2) && (j >= 3 && j < 6)) n = 1;
        else if ((i >= 2 && i < 4) && (j >= 0 && j < 3)) n = 2;
        else if ((i >= 2 && i < 4) && (j >= 3 && j < 6)) n = 3;
        else if ((i >= 4 && i < 6) && (j >= 0 && j < 3)) n = 4;
        else if ((i >= 4 && i < 6) && (j >= 3 && j < 6)) n = 5;
        return n;
    }

    private int squareNumberForGridOfSizeEight(int i, int j) {
        int n = 0;
        if      ((i >= 0 && i < 2) && (j >= 0 && j < 3)) n = 0;
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
        if      ((i >= 0 && i < 3) && (j >= 0 && j < 3)) n = 0;
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

    public Set<Integer> allPossibleValues() {
        return IntStream.rangeClosed(1, cells.size()).boxed().collect(Collectors.toSet());
    }
}
