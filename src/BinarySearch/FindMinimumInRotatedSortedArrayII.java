package BinarySearch;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid - 1;
            else right --;
        }
        return nums[left];
    }

    public int findMin2(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    public int findMinHelper(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[r]) return findMinHelper(nums, mid + 1, r);
        else if (nums[mid] < nums[r]) return findMinHelper(nums, l, mid);
        else return findMinHelper(nums, l, r - 1);
    }
}
