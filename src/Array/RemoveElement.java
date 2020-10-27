package Array;

public class RemoveElement {
    public static int removeElement1(int[] nums, int val) {
        int pos = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[pos] = nums[i];
                pos ++;
            }
        }
        return pos;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n --;
            } else {
                i ++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,3,2,1,2,6};
        int x = RemoveElement.removeElement1(nums, 2);
        System.out.println(x);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
