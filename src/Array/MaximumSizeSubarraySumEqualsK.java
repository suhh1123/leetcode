package Array;

import LinkedList.PalindromeLL;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {
    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,-2,5,3};
        System.out.println(maxSubArrayLen(nums,3));
    }
}
