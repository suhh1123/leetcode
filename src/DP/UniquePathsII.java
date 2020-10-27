package DP;

public class UniquePathsII {
    // Top-down dynamic programming
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // set all obstacle to -1, and the destination to 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        if (obstacleGrid[m - 1][n - 1] == 0) {
            obstacleGrid[m - 1][n - 1] = 1;
        }
        return dfs(obstacleGrid, 0, 0);
    }

    private int dfs(int[][] obstacleGrid, int i, int j) {
        if (i < 0 || i >= obstacleGrid.length || j < 0 || j >= obstacleGrid[0].length || obstacleGrid[i][j] == -1) {
            return 0;
        }
        if (obstacleGrid[i][j] != 0) {
            return obstacleGrid[i][j];
        }
        obstacleGrid[i][j] = dfs(obstacleGrid, i + 1, j) + dfs(obstacleGrid, i, j + 1);
        return obstacleGrid[i][j];
    }

    // Bottom-up dynamic programming
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would no paths to the destination
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1
        obstacleGrid[0][0] = 1;

        // Filling the values for the first row
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 1) ? 0 : obstacleGrid[0][i - 1];
        }

        // Filling the values for the first columb
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
        }

        // Starting from cell(1, 1) fill up the values
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
