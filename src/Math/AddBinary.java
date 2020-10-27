package Math;

public class AddBinary {
    public String addBinary(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
            int sum = x1 + x2 + carry;
            int val = sum % 2;
            carry = sum / 2;
            sb.append(val);
            p1 --;
            p2 --;
        }
        if (carry != 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
