package Tree.SerDer;

import Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBST {

    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null)    return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue, null, null);
    }

    private TreeNode deserialize(Queue<String> queue, Integer lower, Integer upper) {
        if (queue.isEmpty()) return null;
        int val = Integer.valueOf(queue.peek());
        if (lower != null && val <= lower) return null;
        if (upper != null && val >= upper) return null;
        val = Integer.valueOf(queue.poll());
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue, lower, val);
        root.right = deserialize(queue, val, upper);
        return root;
    }
}
