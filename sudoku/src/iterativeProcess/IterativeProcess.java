package iterativeProcess;

import java.util.Stack;

/**
 * Created by bonfa on 11/10/15.
 *
 */
public abstract class IterativeProcess {

    Stack<IterativeStep> solutionStack;

    public IterativeProcess(Stack<IterativeStep> solutionStack) {

        if (solutionStack == null) {

            throw new IllegalStateException("solutionStack can't be null");
        }

        if (solutionStack.isEmpty()) {

            throw new IllegalStateException("solutionStack must contain at least one step");
        }

        this.solutionStack = solutionStack;
    }

    public IterativeProcess(IterativeStep initialStep) throws IllegalStateException {

        if (initialStep == null) {
            throw new IllegalStateException("initialStep can't be null");
        }

        this.solutionStack = new Stack<IterativeStep>();
        solutionStack.push(initialStep);
    }

    public void solve() {

        //TODO
//        while(!((Completable)(solutionStack.get(solutionStack.size() - 1)).getStep().isComplete()) {
//
//
//        }
    }

    public abstract IterativeStep performIteration();

    public abstract void comeBackToStep();
}
