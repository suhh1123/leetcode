package Tree.herringbone;

import Tree.TreeNode;

public class BTMaximumPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, depth(root.left));
        int right = Math.max(0, depth(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
