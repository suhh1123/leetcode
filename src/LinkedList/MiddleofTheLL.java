package LinkedList;

public class MiddleofTheLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        int num = size(head) / 2 + 1;
        ListNode curr = head;
        while (num-1 > 0) {
            curr = curr.next;
            num --;
        }
        return curr;
    }

    private int size(ListNode node) {
        if (node.next == null) {
            return 1;
        }
        return 1 + size(node.next);
    }
}
