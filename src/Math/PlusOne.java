package Math;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            digits[0] = 1;
            return digits;
        }
        int pos = digits.length - 1;
        while (pos >= 0) {
            if (digits[pos] + 1 <= 9) {
                digits[pos] += 1;
                return digits;
            } else {
                digits[pos] = 0;
                if (pos == 0) {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    for (int i = 0; i < digits.length; i++) {
                        res[i + 1] = digits[i];
                    }
                    return res;
                }
                pos --;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        int[] digits = new int[] {9, 9, 9};
        p.plusOne(digits);
    }
}
