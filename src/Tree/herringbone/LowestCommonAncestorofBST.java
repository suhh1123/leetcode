package Tree.herringbone;

import Tree.TreeNode;

public class LowestCommonAncestorofBST {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor1(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor1(root.left, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (p.val > root.val && q.val > root.val) {
                node = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                node = root.left;
            } else {
                return node;
            }
        }
        return null;
    }
}
