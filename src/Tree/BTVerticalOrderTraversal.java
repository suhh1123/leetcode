package Tree;

import java.util.*;

public class BTVerticalOrderTraversal {
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

    int max = 0;
    int min = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        queue.offer(root);
        index.offer(-min);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int idx = index.poll();
            res.get(idx).add(curr.val);
            if (curr.left != null) {
                queue.offer(curr.left);
                index.offer(idx - 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                index.offer(idx + 1);
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int index) {
        if (root == null) return;
        min = Math.min(min, index);
        max = Math.max(max, index);
        dfs(root.left, index - 1);
        dfs(root.right, index + 1);
    }
}
