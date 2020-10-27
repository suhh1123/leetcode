package Tree.Inorder;

import Tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode leftLast = dfs(root.left);
        TreeNode rightLast = dfs(root.right);
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightLast != null) return rightLast;
        if (leftLast != null) return leftLast;
        return root;
    }
}
