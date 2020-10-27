package String;

public class OneEditDistance {
    public static boolean isOneEditDistance(String source, String target) {
        if (source == null || target == null) return false;
        int m = source.length(), n = target.length();
        if (Math.abs(m - n) > 1) return false;
        if (m == n) {
            for (int i = 0; i < source.length(); i++) {
                int count = 0;
                if (source.charAt(i) != target.charAt(i)) {
                    count ++;
                }
                if (count > 1) return false;
            }
        } else if (Math.abs(m - n) == 1) {
            String longer = m > n ? source : target;
            String shorter = m > n ? target : source;
            StringBuilder sb = new StringBuilder(longer);
            for (int i = 0; i < sb.length(); i++) {
                sb.deleteCharAt(i);
                if (!sb.toString().equals(shorter)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abc";
        System.out.print(OneEditDistance.isOneEditDistance(s,t));
    }
}
