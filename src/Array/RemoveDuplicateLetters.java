package Array;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a'] ++;
        }
        for (char c : chars) {
            count[c - 'a'] --;
            if (visited[c - 'a']) {
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length()-1) > c && count[sb.charAt(sb.length()-1) - 'a'] > 0) {
                visited[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c);
            visited[c - 'a'] = true;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        String result = removeDuplicateLetters(s);
        System.out.println(result);
    }
}
