package Math;

public class Pow {
    public double myPow(double x, int n) {
        double res = 1.0;
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }

        double currProduct = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= currProduct;
            }
            currProduct *= currProduct;
        }
        return res;
    }
}
