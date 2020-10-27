package Math;

public class Sqrtx {
    public int mySqrt1(int x) {
        long left = 1;
        long right = (long) x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) left - 1;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        Sqrtx s = new Sqrtx();
        int res = s.mySqrt1(1);
        System.out.print(res);
    }
}
