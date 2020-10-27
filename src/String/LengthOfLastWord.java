package String;

public class LengthOfLastWord {
    public static int lengthOfLastWord1(String s) {
        if (s.isEmpty()) return 0;
        String use = s.trim();
        int count = 0;
        for (int i=use.length()-1; i>=0; i--) {
            if (use.charAt(i) != ' ') count ++;
            else break;
        }
        return count;
    }

    public static int lengthOfLastWord2(String s) {
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }

    public static int lengthOfLastWord3(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(LengthOfLastWord.lengthOfLastWord3(s));
    }
}
