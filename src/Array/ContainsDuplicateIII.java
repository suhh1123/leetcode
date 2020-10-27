package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j - i <= k && j < nums.length; j++) {
                if (Math.abs(Long.valueOf(nums[j]) - Long.valueOf(nums[i])) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceil = set.ceiling(nums[i]);
            if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t) {
                return true;
            }
            Integer floor = set.floor(nums[i]);
            if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
        }
        HashMap<Long, Integer> bucket = new HashMap<>();
        long diff = Long.valueOf(t) + 1;
        for (int i = 0; i < nums.length; i++) {
            long index = (Long.valueOf(nums[i]) - Long.valueOf(min)) / diff;
            // Check left adjacent bucket
            Integer left_bucket = bucket.get(index - 1);
            if (left_bucket != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(left_bucket)) < diff) {
                return true;
            }
            // Check right adjacent bucket
            Integer right_bucket = bucket.get(index + 1);
            if (right_bucket != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(right_bucket)) < diff) {
                return true;
            }
            // Check current bucket
            Integer current_bucket = bucket.get(index);
            if (current_bucket != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(current_bucket)) < diff) {
                return true;
            }
            bucket.put(index, nums[i]);
            if (i >= k) {
                bucket.remove((Long.valueOf(nums[i - k]) - Long.valueOf(min)) / diff);
            }
        }
        return false;
    }
}
