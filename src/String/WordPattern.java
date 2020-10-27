package String;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character,String> map = new HashMap<>();
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = words[i];
            if (map.containsKey(c)) {
                if (map.get(c).equals(s)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!map.containsValue(s)) {
                    map.put(c,s);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        Map map = new HashMap();
        for (Integer i=0; i<words.length; i++) {
            if (map.put(pattern.charAt(i),i) != map.put(words[i],i)) return false;
        } // .put will return the previous values first if it doesn't contain the key, return null
        return true;
    }

    public static void main(String[] args) {
        String pattern = "aba";
        String str = "fish dog cat";
        System.out.println(WordPattern.wordPattern2(pattern,str));
    }
}
