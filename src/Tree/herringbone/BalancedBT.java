package Tree.herringbone;

import Tree.TreeNode;

public class BalancedBT {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        depth(root);
        return flag;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
