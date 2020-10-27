package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer old = map.put(nums[i], i);
            if (old != null && i - old <= k) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length && i <= k; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        for (int i = k + 1; i < nums.length; i++) {
            set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
