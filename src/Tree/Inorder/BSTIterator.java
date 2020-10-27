package Tree.Inorder;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BSTIterator {
    ArrayList<Integer> nodesSorted;
    int index;

    /*public BSTIterator(1TreeNode root) {
        this.nodesSorted = new ArrayList<>();
        this.index = -1;
        this.inorder1(root);
    }*/

    /** @return the next smallest number */
    public int next1() {
        return nodesSorted.get(++index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext1() {
        return index + 1 < nodesSorted.size();
    }

    private void inorder1(TreeNode root) {
        if (root == null) return;
        inorder1(root.left);
        nodesSorted.add(root.val);
        inorder1(root.right);
    }

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        update(root);
    }

    /** @return the next smallest number */
    public int next2() {
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            update(curr.right);
        }
        return curr.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext2() {
        return stack.size() > 0;
    }

    private void update(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
