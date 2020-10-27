package DP;

import java.util.HashMap;

public class HouseRobber {
    // top-down dynamic programming approach1
    public int rob1(int[] nums) {
        int[] res = helper1(nums, 0);
        return Math.max(res[0], res[1]);
    }

    private int[] helper1(int[] nums, int i) {
        // corner case
        if (i == nums.length) {
            return new int[] {0, 0};
        }
        int[] next = helper1(nums, i + 1);
        int rob = nums[i] + next[1];
        int notRob = Math.max(next[0], next[1]);
        return new int[] {rob, notRob};
    }

    // Top-down dynamic programming with memorization approach2
    HashMap<Integer, Integer> robRes = new HashMap<>();
    HashMap<Integer, Integer> notRobRes = new HashMap<>();

    public int rob2(int[] nums) {
        return helper2(nums, 0, false);
    }

    private int helper2(int[] nums, int i, boolean parentRobbed) {
        if (i == nums.length) {
            return 0;
        }
        if (parentRobbed) {
            if (robRes.containsKey(i)) {
                return robRes.get(i);
            }
            int res = helper2(nums, i + 1, false);
            robRes.put(i, res);
            return res;
        } else {
            if (notRobRes.containsKey(i)) {
                return notRobRes.get(i);
            }
            int rob = nums[i] + helper2(nums, i + 1, true);
            int notRob = helper2(nums, i + 1, false);
            int res = Math.max(rob, notRob);
            notRobRes.put(i, res);
            return res;
        }
    }
}
