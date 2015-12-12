package iterativeProcess;

import tree.SolutionNode;
import tree.SolutionTree;
import tree.SolvableTreeNodeData;

/**
 *
 * Created by bonfa on 29/11/15.
 * TODO
 */
public class IterativeMethod {

//    private final SolutionTree mSolutionSolutionTree;
//    private SolutionNode mSolutionNode;
//
//    public IterativeMethod(SolvableTreeNodeData mSolvableTreeNodeData) {
//
//        this.mSolutionSolutionTree = new SolutionTree(mSolvableTreeNodeData);
//    }
//
//    public boolean solve() throws UnsolvableException {
//
//        return executeSolutionStep(mSolutionSolutionTree.getRoot());
//    }
//
//    public SolvableTreeNodeData getSolutionTreeNodeData() {
//
//        return mSolutionNode.getData();
//    }
//
//    private boolean executeSolutionStep(final SolutionNode solutionNode) {
//
//        if (solutionNode.getData().isComplete() && solutionNode.getData().isCorrect()) {
//
//            mSolutionNode = solutionNode;
//
//            return true;
//        } else {
//
//            for (final SolutionNode childSolutionNode : solutionNode.getChildren()) {
//
//                if (executeSolutionStep(childSolutionNode)) {
//
//                    return true;
//                }
//            }
//
//            return false;
//        }
//    }
}
