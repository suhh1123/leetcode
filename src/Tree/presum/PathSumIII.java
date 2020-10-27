package Tree.presum;

import Tree.TreeNode;

public class PathSumIII {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        preorder(root, sum);
        return count;
    }

    private void findPath(TreeNode root, int sum) {
        if (root == null) return;
        if (root.val == sum) {
            count ++;
        }
        findPath(root.left, sum - root.val);
        findPath(root.right, sum - root.val);
    }

    private void preorder(TreeNode root, int sum) {
        if (root == null) return;
        findPath(root, sum);
        preorder(root.left, sum);
        preorder(root.right, sum);
    }
}
