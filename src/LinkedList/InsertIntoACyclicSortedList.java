package LinkedList;

public class InsertIntoACyclicSortedList {
    public static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node();
            node.val = insertVal;
            node.next = node;
            return node;
        }
        Node max = head;
        while (max.next != head && max.val <= max.next.val) {
            max = max.next;
        }
        Node min = max.next;
        if (insertVal >= max.val || insertVal <= min.val) {
            Node node = new Node(insertVal, min);
            max.next = node;
        } else {
            Node curr = max.next;
            while (curr.next.val <= insertVal) {
                curr = curr.next;
            }
            Node node = new Node(insertVal, curr.next);
            curr.next = node;
        }
        return head;
    }
}
