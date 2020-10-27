package Tree.serialization;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class ConstructBSTfromPostorderandInorderTraersal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode build(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postStart < 0 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postStart]);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = build(postStart - (inEnd - inIndex + 1), inStart, inIndex - 1, inorder, postorder);
        root.right = build(postStart - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;
    }
}
