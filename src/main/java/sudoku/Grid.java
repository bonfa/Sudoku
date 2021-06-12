package sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    private final List<List<Cell>> cells;

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
    TODO evolve it to make it work with a number of row different from 9
     */
    public List<Cells> getSquares() {
        List<List<Cell>> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            squares.add(new ArrayList<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int n = getSquareNumber(i, j);

                squares.get(n).add(getRows().get(i).getCells().get(j));
            }
        }

        return squares.stream()
                      .map(Cells::new)
                      .collect(Collectors.toList());
    }

    private static int getSquareNumber(int i, int j) {
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
}
