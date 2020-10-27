package Tree.serialization;

import Tree.TreeNode;

public class ConvertSortedListToBST {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return build(head, null);
    }

    private TreeNode build(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = build(head, slow);
        root.right = build(slow.next, tail);
        return root;
    }
}
