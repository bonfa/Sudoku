package tree;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by bonfa on 29/11/15.
 *
 */
public interface SolvableTreeNodeData {

    @NotNull List<SolvableTreeNodeData> getChildren();

    boolean isComplete();

    boolean isCorrect();
}
