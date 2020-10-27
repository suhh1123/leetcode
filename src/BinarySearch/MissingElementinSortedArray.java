package BinarySearch;

public class MissingElementinSortedArray {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - nums[0] - mid < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int currMiss = nums[left] - nums[0] - left;
        int result = nums[left];
        if (currMiss >= k) {
            int count = (currMiss - k) + 1;
            for (int i = 0; i < count; i++) {
                result --;
            }
        } else {
            int count = k - currMiss;
            for (int i = 0; i < count; i++) {
                result ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MissingElementinSortedArray m = new MissingElementinSortedArray();
        int[] nums = {1,2,4};
        int result = m.missingElement(nums, 1);
        System.out.print(result);
    }
}
