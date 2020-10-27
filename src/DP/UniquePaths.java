package DP;

public class UniquePaths {
    // Top-down dynamic programming
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[m - 1][n - 1] = 1;
        dfs(dp, 0, 0);
        return dp[0][0];
    }

    private int dfs(int[][] dp, int i, int j) {
        if (i < 0 || i >= dp.length || j < 0 || j >= dp[i].length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = dfs(dp, i + 1, j) + dfs(dp, i, j + 1);
        return dp[i][j];
    }

    // Bottom-up dynamic programming
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
