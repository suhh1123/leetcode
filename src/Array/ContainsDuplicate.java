package Array;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
