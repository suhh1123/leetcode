package Math;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count ++;
                for (int j = i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        int count = c.countPrimes(10000);
        System.out.print(count);
    }
}
