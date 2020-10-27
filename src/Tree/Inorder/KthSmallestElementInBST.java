package Tree.Inorder;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementInBST {
    public int kthSmallest1(TreeNode root, int k) {
        ArrayList<Integer> res = inorder(root, new ArrayList<>());
        return res.get(k - 1);
    }

    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return res;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
        return res;
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k = k - 1;
            if (k == 0) return curr.val;
            curr = curr.right;
        }
        return 0;
    }
}
