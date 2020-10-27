package Array;

import java.util.HashSet;

public class RemoveDuplicateFromSortedA {
    public static int removeDuplicates(int[] nums) {
        // corner case
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int x = RemoveDuplicateFromSortedA.removeDuplicates(nums);
        System.out.println(x);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
