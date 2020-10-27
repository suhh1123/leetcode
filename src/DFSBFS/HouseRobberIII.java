package DFSBFS;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode node) {
        // return [rob this node, not rob this node]
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        // if we rob this node, we cannot rob its children
        int rob = node.val + left[1] + right[1];
        // else, we free to choose rob its children or not
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {rob, notRob};
    }

    HashMap<TreeNode, Integer> robResult = new HashMap<>();
    HashMap<TreeNode, Integer> notRobResult = new HashMap<>();
    public int rob2(TreeNode root) {
        return helper2(root, false);
    }

    public int helper2(TreeNode node, boolean parentRobbed) {
        if (node == null) return 0;
        if (parentRobbed) {
            if (robResult.containsKey(node)) {
                return robResult.get(node);
            }
            int res = helper2(node.left, false) + helper2(node.right, false);
            robResult.put(node, res);
            return res;
        } else {
            if (notRobResult.containsKey(node)) {
                return notRobResult.get(node);
            }
            int rob = node.val + helper2(node.left, true) + helper2(node.right, true);
            int notRob = helper2(node.left, false) + helper2(node.right, false);
            int res = Math.max(rob, notRob);
            notRobResult.put(node, res);
            return res;
        }
    }
}
