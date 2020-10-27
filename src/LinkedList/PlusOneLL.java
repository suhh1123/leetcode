package LinkedList;

public class PlusOneLL {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode plusOne1(ListNode head) {
        ListNode revList = reverse(head);
        ListNode curr = revList;
        ListNode prev = null;
        int carry = 1;
        while (curr != null) {
            int sum = curr.val + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = prev;
            prev = node;
            carry = sum / 10;
            curr = curr.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(1);
            node.next = prev;
            prev = node;
        }
        return prev;
    }

    public ListNode plusOne2(ListNode head) {
        ListNode revList = reverse(head);
        ListNode p = revList;
        while (p != null) {
            if (p.val + 1 <= 9) {
                p.val ++;
                break;
            } else {
                p.val = 0;
                if (p.next == null) {
                    p.next = new ListNode(1);
                    break;
                }
                p = p.next;
            }
        }
        return reverse(revList);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        PlusOneLL p = new PlusOneLL();
        ListNode head = new ListNode(9,new ListNode(9,new ListNode(9)));
        ListNode result = p.plusOne2(head);
    }
}
