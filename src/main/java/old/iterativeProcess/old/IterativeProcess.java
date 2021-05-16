package old.iterativeProcess.old;

/**
 * Created by bonfa on 11/10/15.
 *TODO
 */
public abstract class IterativeProcess<Completable> {

//    final Stack<IterativeStep> solutionStack;
//    final List<IterativeStep> blackListStep;
//    private int numberOfAmbigousSteps;
//
//    public IterativeProcess(Stack<IterativeStep> solutionStack) {
//
//        if (solutionStack == null) {
//
//            throw new IllegalStateException("solutionStack can't be null");
//        }
//
//        if (solutionStack.isEmpty()) {
//
//            throw new IllegalStateException("solutionStack must contain at least one step");
//        }
//
//        this.solutionStack = solutionStack;
//        this.blackListStep = new ArrayList<IterativeStep>();
//        this.numberOfAmbigousSteps = 0;
//    }
//
//    public IterativeProcess(Completable completable) throws IllegalStateException {
//
//        final IterativeStep step = new IterativeStep(completable, false, , 0);
//
//        if (initialStep == null) {
//            throw new IllegalStateException("initialStep can't be null");
//        }
//
//        this.blackListStep = new ArrayList<IterativeStep>();
//
//        this.solutionStack = new Stack<IterativeStep>();
//        solutionStack.push(initialStep);
//
//        if (initialStep.isAmbigous()) {
//
//            this.numberOfAmbigousSteps = 1;
//        }
//        else {
//
//            this.numberOfAmbigousSteps = 0;
//        }
//    }
//
//    public IterativeStep solve() {
//
//        while(!(solutionStack.get(solutionStack.size() - 1)).getStep().isComplete()) {
//
//            try {
//                IterativeStep step = solutionStack.get(solutionStack.size() - 1);
//
//                if (step.isAmbigous() && step.getStep().canBeSolved()) {
//
//                    numberOfAmbigousSteps++;
//                    step.setNumberOfAttemptsToSolve(step.getNumberOfAttemptsToSolve()+1);
//                }
//
//                solutionStack.push(performIteration(step));
//            }
//            catch (IllegalStateException e) {
//
//                if (numberOfAmbigousSteps == 0) {
//
//                    return null;
//                }
//                else {
//
//                    comeBackToFirstAmbigousStep();
//
//                    return solve();
//                }
//            }
//        };
//    }
//
//    public abstract IterativeStep performIteration(final IterativeStep iterativeStep);
//
//    public void comeBackToFirstAmbigousStep() {
//
//        for (ListIterator<IterativeStep> iterator = solutionStack.listIterator(); iterator.hasNext();) {
//
//            IterativeStep step = iterator.next();
//            if (step.isAmbigous()) {
//                break;
//            }
//            else {
//
//                blackListStep.add(step);
//                iterator.remove();
//            }
//        }
//    }
}
