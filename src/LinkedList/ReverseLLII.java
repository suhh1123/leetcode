package LinkedList;

public class ReverseLLII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while (m < 1) {
            prev = curr;
            curr = curr.next;
            m --;
            n --;
        }
        ListNode connection = prev;
        ListNode tail = curr;
        while (n > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n --;
        }
        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }
        tail.next = curr;
        return head;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i=0; i<m-1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode then = start.next;
        for (int i=0; i<n-m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
