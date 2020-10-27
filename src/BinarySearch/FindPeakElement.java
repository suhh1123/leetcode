package BinarySearch;

public class FindPeakElement {
    public int findPeakElement1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) return l;
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        } else {
            return search(nums, mid + 1, r);
        }
    }
}
