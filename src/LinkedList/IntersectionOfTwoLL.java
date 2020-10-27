package LinkedList;

public class IntersectionOfTwoLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // Corner case
        if (headA == null || headB == null) return null;

        int len1 = size(headA);
        int len2 = size(headB);
        ListNode p1 = headA;
        ListNode p2 = headB;
        if (len1 > len2) {
            for (int i=0; i<len1-len2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i=0; i<len2-len1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    private int size(ListNode l) {
        if (l == null) return 0;
        if (l.next == null) return 1;
        return 1 + size(l.next);
    }
}
