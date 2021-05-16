package old.iterativeProcess.old;

/**
 * Created by bonfa on 11/10/15.
 *
 */
public class IterativeStep {

    private final Completable step;
    private final boolean ambigous;
    private final boolean erasableState;
    private int numberOfAttemptsToSolve;

    public IterativeStep(final Completable step, final boolean erasableState, final boolean ambigous, final int numberOfAttemptsToSolve) {

        this.step = step;
        this.erasableState = erasableState;
        this.ambigous = ambigous;
        this.numberOfAttemptsToSolve = numberOfAttemptsToSolve;
    }

    public Completable getStep() {
        return step;
    }

    public boolean isErasableState() {
        return erasableState;
    }

    public boolean isAmbigous() {
        return ambigous;
    }

    public int getNumberOfAttemptsToSolve() {
        return numberOfAttemptsToSolve;
    }

    public void setNumberOfAttemptsToSolve(int numberOfAttemptsToSolve) {
        this.numberOfAttemptsToSolve = numberOfAttemptsToSolve;
    }
}
