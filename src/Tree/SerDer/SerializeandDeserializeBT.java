package Tree.SerDer;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // corner case
        if (root == null) return "";
        // BFS-queue
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("null");
            } else {
                sb.append(curr.val);
                queue.offer(root.left);
                queue.offer(root.right);
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // corner case
        if (data == null || data.length() == 0) return null;
        // split
        String[] arr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        for (int i = 1; i < arr.length; i++) {
            TreeNode parent = queue.poll();
            if (!arr[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (!arr[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
