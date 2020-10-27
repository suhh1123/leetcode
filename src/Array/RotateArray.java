package Array;

public class RotateArray {
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start ++;
            end --;
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i=0; count< nums.length; i++) {
            int prev = nums[i];
            int curr = i;
            int next_index = (i + k) % nums.length;
            while (curr != next_index) {
                int temp = nums[next_index];
                nums[next_index] = prev;
                prev = temp;
                next_index = (next_index + k) % nums.length;
                count ++;
            }
            nums[next_index] = prev;
            count ++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        RotateArray r = new RotateArray();
        r.rotate2(nums,2);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
