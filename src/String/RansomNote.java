package String;

import java.util.HashMap;

public class RansomNote {
    public static boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character,Integer> count = new HashMap<>();
        for (int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            count.put(c, count.getOrDefault(c,0) + 1);
        }
        for (int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!count.containsKey(c)) {
                return false;
            }
            count.put(c, count.get(c) - 1);
            if (count.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] ch = new int[26];
        for (int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            ch[c - 'a'] += 1;
        }
        for (int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            ch[c - 'a'] -= 1;
            if (ch[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "a";
        System.out.print(RansomNote.canConstruct2(ransomNote,magazine));
    }
}
