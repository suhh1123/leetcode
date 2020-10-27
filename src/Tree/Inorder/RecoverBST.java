package Tree.Inorder;

import Tree.TreeNode;

public class RecoverBST {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        boolean firstTime = true;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode current = root;
        while (current != null) {
            // left is null then visit the node and go to right
            if (current.left == null) {
                // visit
                if (prev.val > current.val && firstTime) {
                    first = prev;
                    firstTime = false;
                }
                if (prev.val > current.val && !firstTime) {
                    second = current;
                }
                prev = current;
                current = current.right;
            } else {
                // find the predecessor
                TreeNode predecessor = current.left;
                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                // if right node is null then go left after establishing link from predecessor to current
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else { // left is already visit, go right after visit current
                    predecessor.right = null;
                    // visit
                    if (prev.val > current.val && firstTime) {
                        first = prev;
                        firstTime = false;
                    }
                    if (prev.val > current.val && !firstTime) {
                        second = current;
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
