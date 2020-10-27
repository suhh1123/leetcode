package Array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        boolean containsOne = false;
        // first pass
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) containsOne = true;
            else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        if (!containsOne) return 1;
        // second pass
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        // third pass
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
