package LinkedList;

public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs1(ListNode head) {
        // Corner case
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode n = curr.next.next;
            curr.next.next = n.next;
            n.next = curr.next;
            curr.next = n;
            curr = curr.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = swapPairs2(head.next.next);
        ListNode curr = head.next;
        head.next = res;
        curr.next = head;
        return curr;
    }

    public static void main(String[] args) {
        SwapNodesInPairs s = new SwapNodesInPairs();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode result = s.swapPairs2(head);
    }
}
