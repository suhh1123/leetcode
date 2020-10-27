package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        if (lists == null || lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, (l1, l2) -> l1.val - l2.val);
        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            curr.next = temp;
            if (temp.next != null) {
                minHeap.offer(temp.next);
            }
            curr = temp;
        }
        return dummy.next;
    }
}
