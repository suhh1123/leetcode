package Tree.presum;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        findPath(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void findPath(TreeNode root, int sum, List<Integer> current, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(current);
            return;
        }
        findPath(root.left, sum - root.val, new ArrayList<>(current), res);
        findPath(root.right, sum - root.val, new ArrayList<>(current), res);
    }
}
