package DFSBFS;

import java.util.PriorityQueue;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numsIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numsIsland += dfs(grid, i, j);
                }
            }
        }
        return numsIsland;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return 1;
    }

    public int bfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') return 0;
        int[] coord = new int[] {i, j};
        PriorityQueue<int[]> pq = new PriorityQueue<>();
        pq.offer(coord);
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            grid[curr[0]][curr[1]] = 0;
            if (i + 1 >= 0 && i + 1 < grid.length) pq.offer(new int[] {i + 1, j});
            if (i - 1 >= 0 && i - 1 < grid.length) pq.offer(new int[] {i - 1, j});
            if (j + 1 >= 0 && j + 1 < grid[0].length) pq.offer(new int[] {i, j + 1});
            if (j - 1 >= 0 && j - 1 < grid[0].length) pq.offer(new int[] {i, j - 1});
        }
        return 1;
    }
}
