package Tree.herringbone;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SubTOfAnotherT {
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) != -1;
    }

    private String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left) {
                return "lnull";
            } else {
                return "rnull";
            }
        }
        return "#" + t.val + " " + preorder(t.left, true) + " " + preorder(t.right, false);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (equals(curr, s)) return true;
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return false;
    }

    private boolean equals(TreeNode x, TreeNode y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }

    public static void main(String[] args) {
        SubTOfAnotherT s = new SubTOfAnotherT();
        TreeNode ss = new TreeNode(4);
        ss.left = new TreeNode(1);
        ss.right = new TreeNode(2);

        TreeNode tt = new TreeNode(3);
        tt.left = new TreeNode(4);
        tt.left.left = new TreeNode(1);
        tt.left.left.left = new TreeNode(0);
        tt.left.right = new TreeNode(2);
        tt.right = new TreeNode(5);

        System.out.print(s.isSubtree2(ss,tt));
    }
}
