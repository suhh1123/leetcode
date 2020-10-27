package BinarySearch;

public class SplitArrayLargestSum {
    public int splitArray1(int[] nums, int m) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int pieces = split(nums, mid);
            if (pieces > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int split(int[] nums, int largestSum) {
        int piece = 1;
        int tempSum = 0;
        for (int num : nums) {
            if (tempSum + num > largestSum) {
                tempSum = num;
                piece ++;
            } else {
                tempSum += num;
            }
        }
        return piece;
    }

    Integer[][] memo;
    int[] prefix;
    public int splitArray2(int[] nums, int m) {
        int n = nums.length;
        memo = new Integer[m + 1][n + 1];
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return dfs(nums, m, n);
    }

    public int dfs(int[] nums, int m, int n) {
        if (m == 1) {
            return prefix[n];
        }
        if (m > n) {
            return -1;
        }
        if (memo[m][n] != null) {
            return memo[m][n];
        }
        int res = Integer.MAX_VALUE;
        for (int k = 1; k < n; k++) {
            int left = dfs(nums, m - 1, k);
            if (left == -1) {
                continue;
            }
            int right = prefix[n] - prefix[k];
            int sub = Math.max(left, right);
            res = Math.min(res, sub);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        return memo[m][n] = res;
    }
}
