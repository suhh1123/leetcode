package LinkedList;

import java.util.Stack;

public class AddTwoNumII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        Stack<ListNode> s2 = new Stack<>();
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode resNode = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int x1 = s1.isEmpty() ? 0 : s1.pop().val;
            int x2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = x1 + x2 + carry;
            ListNode n = new ListNode(sum % 10);
            n.next = resNode;
            resNode = n;
            carry = sum / 10;
        }
        if (carry != 0) {
            ListNode n = new ListNode(1);
            n.next = resNode;
            resNode = n;
        }
        return resNode;
    }

    public ListNode addTwoNumber2(ListNode l1, ListNode l2) {
        int s1 = size(l1);
        int s2 = size(l2);
        ListNode resHead = null;
        ListNode n = null;
        int v1 = 0;
        int v2 = 0;
        while (l1 != null || l2 != null) {
            if (s1 >= s2) {
                v1 = l1 != null ? l1.val : 0;
                l1 = l1.next;
                s1 --;
            }
            if (s2 >= s1 + 1) {
                v2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                s2 --;
            }
            n = new ListNode(v1 + v2);
            n.next = resHead;
            resHead = n;
        }
        int carry = 0;
        resHead = null;
        while (n != null) {
            int sum = n.val + carry;
            n.val = sum % 10;
            carry = sum / 10;
            ListNode curr = n.next;
            n.next = resHead;
            resHead = n;
            n = curr;
        }
        if (carry != 0) {
            n = new ListNode(1);
            n.next = resHead;
            resHead = n;
        }
        return resHead;
    }

    private int size(ListNode l) {
        int s = 0;
        while (l != null) {
            l = l.next;
            s++;
        }
        return s;
    }
}
