package Math;

public class TwoSumII {
    // Time complexity : O(n) Space complexity : O(1)
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0, p2 = numbers.length - 1;
        while (p2 > p1) {
            int sum = numbers[p1] + numbers[p2];
            if (sum == target) {
                return new int[] {p1 + 1, p2 + 1};
            } else if (sum < target) {
                p1 ++;
            } else {
                p2 --;
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}
