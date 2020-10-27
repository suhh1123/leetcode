package Array;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedAII {
    public static int removeDuplicates(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 3) return nums.length;
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (!(nums[fast] == nums[slow - 1] && nums[fast] == nums[slow - 2])) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int x = RemoveDuplicatesFromSortedAII.removeDuplicates(nums);
        System.out.println(x);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
