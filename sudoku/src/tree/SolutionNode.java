package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bonfa on 29/11/15.
 *
 */
public final class SolutionNode {

    private final SolvableTreeNodeData mData;
    private final SolutionNode mFather;
    private List<SolutionNode> mChildren;

    //hide default constructor
    private SolutionNode(){

        mData = null;
        mFather = null;
    }

    public SolutionNode(final SolvableTreeNodeData data, final SolutionNode father) {

        this.mData = data;
        this.mFather = father;
    }

    public SolvableTreeNodeData getData() {

        return mData;
    }

    public List<SolutionNode> getChildren() {

        if (mChildren == null) {

            mChildren = createChildrenList();
        }

        return mChildren;
    }

    private List<SolutionNode> createChildrenList() {

        final List<SolvableTreeNodeData> childrenNodeDataList = mData.getChildren();

        final List<SolutionNode> solutionNodeList = new ArrayList<>();

        for (final SolvableTreeNodeData solvableTreeNodeData : childrenNodeDataList) {

            solutionNodeList.add(new SolutionNode(solvableTreeNodeData, this));
        }

        return solutionNodeList;
    }

    public boolean isRoot() {

        return mFather == null;
    }
}



