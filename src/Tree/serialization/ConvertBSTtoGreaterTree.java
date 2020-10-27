package Tree.serialization;

import Tree.TreeNode;

public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST1(TreeNode root) {
        if (root != null) {
            convertBST1(root.left);
            sum += root.val;
            root.val = sum;
            convertBST1(root.right);
        }
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.right == null) {
                // visit
                sum += curr.val;
                curr.val = sum;
                curr = curr.left;
            } else {
                TreeNode successor = curr.right;
                while (successor.left != curr && successor.left != null) {
                    successor = successor.left;
                }
                if (successor.left == null) {
                    successor.left = curr;
                    curr = curr.right;
                } else {
                    successor.left = null;
                    // visit
                    sum += curr.val;
                    curr.val = sum;
                    curr = curr.left;
                }
            }
        }
        return root;
    }
}
