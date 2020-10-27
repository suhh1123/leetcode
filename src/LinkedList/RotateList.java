package LinkedList;

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int p = size(head) - (k % size(head));
        if (p == size(head)) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i=0; i<p; i++) {
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        curr = newHead;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return newHead;
    }

    public int size(ListNode head) {
        if (head == null) return 0;
        if (head.next == null) return 1;
        return 1 + size(head.next);
    }
}
