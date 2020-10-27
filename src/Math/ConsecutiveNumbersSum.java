package Math;

import java.util.HashMap;
import java.util.Map;

public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int i = 1; i < Math.sqrt(2 * N); i++) {
            if ((2 * N - i * i + i) % (2 * i) == 0 && (2 * N - i * i + i) > 0) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ConsecutiveNumbersSum c = new ConsecutiveNumbersSum();
        int res = c.consecutiveNumbersSum(79932);
        System.out.print(res);
    }
}
