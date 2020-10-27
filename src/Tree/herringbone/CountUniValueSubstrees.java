package Tree.herringbone;

import Tree.TreeNode;

public class CountUniValueSubstrees {
    int count;
    public int countUnivalueSubtrees(TreeNode root) {
        count = 0;
        if (root == null) return 0;
        isUnivalueSubtree(root);
        return count;
    }

    private boolean isUnivalueSubtree(TreeNode root) {
        if (root == null) return true;
        boolean isLeftUnivalSubtree = isUnivalueSubtree(root.left);
        boolean isRightUnivalSubtree = isUnivalueSubtree(root.right);
        if (isLeftUnivalSubtree && isRightUnivalSubtree && (root.left == null || root.left.val == root.val)
        && (root.right == null || root.right.val == root.val)) {
            count ++;
            return true;
        }
        return false;
    }
}
