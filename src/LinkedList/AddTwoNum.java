package LinkedList;

public class AddTwoNum {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int val1 = p1 != null ? p1.val : 0;
            int val2 = p2 != null ? p2.val : 0;
            int value = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            curr.next = new ListNode(value);
            curr = curr.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNum ad = new AddTwoNum();
        ListNode l1 = new ListNode(1, new ListNode(8, null));
        ListNode l2 = new ListNode(0);
        ListNode result = ad.addTwoNumbers(l1,l2);
    }
 }
