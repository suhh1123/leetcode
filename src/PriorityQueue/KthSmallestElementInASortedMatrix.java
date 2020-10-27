package PriorityQueue;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static class Node {
        int row, col;
        Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> matrix[a.row][a.col] - matrix[b.row][b.col]);

        for (int i = 0; i < matrix[0].length && i < k; i++) {
            pq.offer(new Node(0, i));
        }

        while (k > 1) {
            Node node = pq.poll();
            if (node.row + 1 < matrix.length) {
                pq.offer(new Node(node.row + 1, node.col));
            }
            k --;
        }

        return matrix[pq.peek().row][pq.peek().col];
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix k = new KthSmallestElementInASortedMatrix();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int res = k.kthSmallest(matrix, 20);
        System.out.print(res);
    }
}
