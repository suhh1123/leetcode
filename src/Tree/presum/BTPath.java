package Tree.presum;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTPath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        findPath(root, new StringBuilder(), res);
        return res;
    }

    private void findPath(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) return;
        sb.append(root.val);
        sb.append("->");
        if (root.left == null && root.right == null) {
            String s = sb.substring(0, sb.length() - 2);
            res.add(s);
        }
        findPath(root.left, new StringBuilder(sb), res);
        findPath(root.right, new StringBuilder(sb), res);
    }
}
