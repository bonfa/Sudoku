package old.iterativeProcess.tree;

import java.util.List;

/**
 * Created by bonfa on 29/11/15.
 *
 */
public interface SolvableTreeNodeData {

    List<SolvableTreeNodeData> getChildren();

    boolean isComplete();

    boolean isCorrect();
}
