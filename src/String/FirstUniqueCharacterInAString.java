package String;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> count = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c =  s.charAt(i);
            count.put(c, count.getOrDefault(c,0)+1);
        }

        for (int i=0; i<s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.print(FirstUniqueCharacterInAString.firstUniqChar(s));
    }
}
