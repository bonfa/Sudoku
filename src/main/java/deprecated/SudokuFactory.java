package deprecated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Deprecated
public class SudokuFactory {
    public SudokuV2 emptySudoku() {
        List<Cells> rows = Collections.nCopies(9, Collections.nCopies(9, CellV2.emptyCell()))
                                         .stream()
                                         .map(Cells::new)
                                         .collect(Collectors.toList());

        return new SudokuV2(rows, toColumn(rows), toSquares(rows));
    }

    public SudokuV2 fromRows(List<Cells> rows) {
        //todo evaluate how to manage the constraints
        return new SudokuV2(rows, toColumn(rows), toSquares(rows));
    }

    public static List<Cells> toColumn(List<Cells> rows) {
        return IntStream.range(0, rows.get(0).size())
                        .mapToObj(i -> new Cells(rows.stream().map(l -> l.getCells().get(i)).collect(Collectors.toList())))
                        .collect(Collectors.toList());
    }

    public static List<Cells> toSquares(List<Cells> rows) {
        var grid = rows.stream()
                       .map(Cells::getCells)
                       .flatMap(Collection::stream)
                       .collect(Collectors.toList());

        List<List<CellV2>> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            squares.add(new ArrayList<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int n = getSquareNumber(i, j);

                squares.get(n).add(rows.get(i).getCells().get(j));
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

