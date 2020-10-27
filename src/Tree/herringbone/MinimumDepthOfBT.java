package Tree.herringbone;

import Tree.TreeNode;

public class MinimumDepthOfBT {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return Math.min(left, right) + 1;
        } else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
