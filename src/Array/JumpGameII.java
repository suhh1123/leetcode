package Array;

public class JumpGameII {
    // for each step of jump, there is a range you can reach
    // then try jumping from each position in current range, you will get a new range
    // where the next step can reach
    // repeat the process until the range covers the last index
    public int jump1(int[] nums) {
        int step = 0;
        for (int l = 0, r = 0;  r < nums.length - 1; step++) {
            int rNew = 0;
            for (int i = l; i <= r; i++) {
                rNew = Math.max(rNew, i + nums[i]);
            }
            l = r + 1;
            r = rNew;
        }
        return step;
    }

    public int jump2(int[] nums) {
        int furthestPos = 0;
        int current = 0;
        int jump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthestPos = Math.max(furthestPos, i + nums[i]);
            if (current == i) {
                jump ++;
                current = furthestPos;
            }
        }
        return jump;
    }
}
