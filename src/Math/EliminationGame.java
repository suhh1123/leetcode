package Math;

public class EliminationGame {
    public int lastRemaining1(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int[] res = helper(nums, true);
        return res[0];
    }

    private int[] helper(int[] nums, boolean LeftToRight) {
        if (nums.length == 1) return nums;
        if (LeftToRight) return helper(deleteFromLeftToRight(nums), false);
        else return helper(deleteFromRightToLeft(nums), true);
    }

    private int[] deleteFromLeftToRight(int[] nums) {
        int[] res = new int[nums.length / 2];
        int pos = 1;
        for (int i = 0; i < res.length && pos < nums.length; i++) {
            res[i] = nums[pos];
            pos += 2;
        }
        return res;
    }

    private int[] deleteFromRightToLeft(int[] nums) {
        int[] res = new int[nums.length / 2];
        int pos = nums.length - 2;
        for (int i = res.length - 1; i >= 0 && pos >= 0; i--) {
            res[i] = nums[pos];
            pos -= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        EliminationGame e = new EliminationGame();
        int[] nums = {2, 6};
        /*int[] res = e.deleteFromLeftToRight(nums);
        for (int num : res) {
            System.out.print(num);
        }*/
        int res = e.lastRemaining1(16);
        System.out.print(res);
    }

    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}
