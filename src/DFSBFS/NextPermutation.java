package DFSBFS;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        int small = -1;
        int big = -1;
        // Iterate nums from left to right, find the first element that is less than its next
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                small = i;
                break;
            }
        }
        // If small is equals to -1, reverse the whole array
        if (small == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        // Interate nums from left to right until hit small, find the first element that is larger than small element
        for (int i = n - 1; i > small; i--) {
            if (nums[i] > nums[small]) {
                big = i;
                break;
            }
        }
        swap(nums, small, big);
        reverse(nums, small + 1, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start; i <= start + (end - start) / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[end + start - i];
            nums[end + start - i] = tmp;
        }
    }

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
