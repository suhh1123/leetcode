package Tree.herringbone;

import Tree.BTInorderTraversal;
import Tree.TreeNode;
public class MaximumDepthOfBT {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
