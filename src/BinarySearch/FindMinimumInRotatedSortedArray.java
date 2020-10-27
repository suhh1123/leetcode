package BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMin2(int[] nums) {
        return findMin2(nums, 0, nums.length - 1);
    }

    public int findMin2(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[right]) return findMin2(nums, mid + 1, right);
        else return findMin2(nums, left, mid);
    }
}
