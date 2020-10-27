package BinarySearch;

public class SearchInsertPosition {
    public int searchInsert1(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (target < nums[left]) return left;
            if (target > nums[right]) return right + 1;
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return  mid;
            else if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
