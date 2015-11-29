package tree;

/**
 *
 * Created by bonfa on 29/11/15.
 *
 */
public class SolutionTree {

    private SolutionNode mRoot;

    public SolutionTree(SolvableTreeNodeData solvableTreeNodeData) {

        mRoot = new SolutionNode(solvableTreeNodeData);
    }

    public SolutionNode getRoot() {

        return mRoot;
    }
}
