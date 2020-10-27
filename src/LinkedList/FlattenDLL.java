package LinkedList;

public class FlattenDLL {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten1(Node head) {
        Node curr = head;

        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
            } else {
                Node parent = curr;
                Node parentNext = parent.next;
                Node child = parent.child;
                Node childLast = child;
                parent.child = null;
                while (childLast != null && childLast.next != null) {
                    childLast = childLast.next;
                }
                parent.next = child;
                child.prev = parent;
                childLast.next = parentNext;
                if (parentNext != null) {
                    parentNext.prev = childLast;
                }
            }
        }
        return head;
    }

    public Node flatten2(Node head) {
        Node curr = head;
        while (curr != null && curr.child == null) {
            curr = curr.next;
        }
        if (curr == null) {
            return head;
        }
        Node temp = curr.next;
        Node fl = flatten2(curr.child);
        curr.next = fl;
        fl.prev = curr;
        curr.child = null;
        while (curr.next != null) {
            curr = curr.next;
        }
        if (temp != null) {
            Node fltmp = flatten2(temp);
            curr.next = temp;
            temp.prev = curr;
        }
        return head;
    }
}
