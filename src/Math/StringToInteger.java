package Math;

public class StringToInteger {
    public int myAtoi(String str) {
        int pos = 0;
        int res = 0;
        int sign = 1;
        if (str == null || str.length() == 0) return 0;

        while (pos < str.length() && str.charAt(pos) == ' ') pos ++;

        if (pos < str.length() && (str.charAt(pos) == '+' || str.charAt(pos) == '-')) {
            sign = str.charAt(pos) == '+' ? 1 : -1;
            pos ++;
        }

        while (pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
            int digit = str.charAt(pos) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            pos ++;
        }
        return res * sign;
    }

    public static void main(String[] args) {
        StringToInteger s = new StringToInteger();
        s.myAtoi("-2147483648");
    }
}
