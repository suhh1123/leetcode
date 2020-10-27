package BinarySearch;

import java.util.Random;

public class RandomPickWithWeight {
    Random rand;
    int[] sum;
    public RandomPickWithWeight(int[] w) {
        rand = new Random();
        sum = w.clone();
        for (int i = 1; i < w.length; i++) {
            sum[i] += sum[i - 1];
        }
    }

    public int pickIndex() {
        int total = sum[sum.length - 1];
        int guess = rand.nextInt(total) + 1;
        int left = 0, right = sum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == guess) {
                return mid;
            } else if (sum[mid] < guess) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
