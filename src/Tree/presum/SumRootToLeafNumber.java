package Tree.presum;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumber {
    int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        findNum(root, 0);
        return res;
    }

    private void findNum(TreeNode root, int val) {
        if (root == null) return;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += val;
        }
        findNum(root.left, val);
        findNum(root.right, val);
    }
}
