package Math;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        for (int i = 0; i < num2.length(); i++) {
            String s = multiply(num1, num2, i);
            res = addStrings(res, s);
        }
        return res;
    }

    private String multiply(String num1, String num2, int i) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < i; k++) {
            sb.append(0);
        }
        int carry = 0;
        int x2 = num2.charAt(num2.length() - 1 - i) - '0';
        int p = num1.length() - 1;
        while (p >= 0) {
            int x1 = num1.charAt(p) - '0';
            int sum = x1 * x2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            sb.append(val);
            p --;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int sum = x1 + x2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            sb.append(val);
            p1 --;
            p2 --;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        String res = m.multiply(num1, num2);
        System.out.print(res);
    }
}
