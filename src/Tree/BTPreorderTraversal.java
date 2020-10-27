package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        BTPreorderTraversal bst = new BTPreorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode curr = root;
        curr.right = new TreeNode(2);
        curr = curr.right;
        curr.left = new TreeNode(3);
        List<Integer> res = bst.preorderTraversal2(root);
        System.out.print(res);
    }
}
