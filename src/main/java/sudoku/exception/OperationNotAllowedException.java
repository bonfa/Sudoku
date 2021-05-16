package sudoku.exception;

/**
 * Created by bonfa on 07/12/15.
 */
public class OperationNotAllowedException extends Throwable {

    public OperationNotAllowedException() {
    }

    public OperationNotAllowedException(final String s) {

        super(s);
    }
}
