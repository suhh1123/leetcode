package String;

public class CountAndSay {
    public String countAndSay(int n) {
        return countHelper("1", n);
    }

    public String countHelper(String s, int n) {
        if (n == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        if (s.length() == 1) {
            result.append(1);
            result.append(s.charAt(0));
            return countHelper(result.toString(), n-1);
        }

        int count = 1;
        char curr = s.charAt(0);
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == curr) {
                count ++;
            } else {
                result.append(count);
                result.append(curr);
                curr = s.charAt(i);
                count = 1;
            }
            if (i == s.length() - 1) {
                result.append(count);
                result.append(curr);
            }
        }
        return countHelper(result.toString(), n-1);
    }

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        String result = c.countAndSay(7);
        System.out.print(result);
    }
}
