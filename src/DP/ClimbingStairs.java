package DP;

public class ClimbingStairs {
    // Top-down dynamic programming
    public int climbStairs1(int n) {
        int[] memo = new int[n + 1];
        return climb_Stairs1(0, n, memo);
    }

    public int climb_Stairs1(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs1(i + 1, n, memo) + climb_Stairs1(i + 2, n, memo);
        return memo[i];
    }

    // Bottom-up dynamic programming
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
