package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandII {
    public List<Integer> numIsland2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        Arrays.fill(parent, - 1);

        ArrayList<Integer> res = new ArrayList<>();

        int[] dx = {-1, 0 ,1, 0};
        int[] dy = {0, -1, 0, 1};

        int count = 0;
        for (int[] position : positions) {
            count ++;
            int idx = position[0] * n + position[1];

            if (parent[idx] == -1) {
                parent[idx] = idx;
            }

            for (int k = 0; k < 4; k++) {
                int x = position[0] + dx[k];
                int y = position[1] + dy[k];

                int idxNeighbor = n * x + y;

                if (x >= 0 && x < m && y >= 0 && y < n && parent[idxNeighbor] != - 1) {
                    int p = getParent(parent, idxNeighbor);

                    if (parent[p] != idx) {
                        parent[p] = idx;
                        count --;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    private int getParent(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }
}
