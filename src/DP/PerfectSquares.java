package DP;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int end = (int) Math.floor(Math.sqrt(n));
        int[] memo = new int[n + 1];
        Arrays.fill(memo, n + 1);
        memo[0] = 0;

        for (int j = 1; j <= end; j++) {
            for (int i = 1; i <= n; i++) {
                if (i >= j * j) {
                    memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
                }
            }
        }
        return memo[n];
    }
}
