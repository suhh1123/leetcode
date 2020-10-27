package LinkedList;

public class RemoveNthNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (n == 0) return head;
        ListNode revList = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = revList;
        ListNode curr = dummy;
        for (int i=0; i<n-1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return reverse(dummy.next);
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for (int i=0 ;i<n+1; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
