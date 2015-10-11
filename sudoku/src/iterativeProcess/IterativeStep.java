package iterativeProcess;

/**
 * Created by bonfa on 11/10/15.
 *
 */
public class IterativeStep<Completable> {

    private final Completable step;
    private final boolean erasableState;

    public IterativeStep(Completable step, boolean erasableState) {
        this.step = step;
        this.erasableState = erasableState;
    }

    public Completable getStep() {
        return step;
    }

    public boolean isErasableState() {
        return erasableState;
    }
}
