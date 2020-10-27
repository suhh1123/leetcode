package LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList1(Node head) {
        HashMap<Node,Node> map = new HashMap<>();

        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }

        Node q = head;
        while (q != null) {
            map.get(q).next = map.get(q.next);
            map.get(q).random = map.get(q.random);
            q = q.next;
        }

        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return null;

        // First Pass, for each node in the original list, insert a copied node
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }

        // Second Pass, link the random pointer for the copied node
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Third Pass, extract the copied node
        /*curr = head;
        Node dummy = new Node(0);
        Node copyPrev = dummy;
        while (curr != null) {
            copyPrev.next = curr.next;
            curr.next = curr.next.next;
            copyPrev = copyPrev.next;
            curr = curr.next;
        }
        return dummy.next;*/
        Node p1 = head;
        Node p2 = head.next;
        Node copyHead = p2;
        while (p2.next != null) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = null;
        return copyHead;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer c = new CopyListWithRandomPointer();
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n2.next = n3;
        head.next = n2;
        n2.random = head;

        c.copyRandomList2(head);
    }
}
