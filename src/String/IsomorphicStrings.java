package String;

import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic1(String s, String r) {
        if (s == null || s.length() <= 1) return true;
        HashMap<Character,Character> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            char b = r.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!map.containsValue(b)) {
                    map.put(a,b);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String r) {
        int[] m = new int[512];
        for (int i=0; i<s.length(); i++) {
            if (m[s.charAt(i)] != m[r.charAt(i) + 256]) return false;
            m[s.charAt(i)] = m[r.charAt(i) + 256] = i+1;
        }
        return true;
    }
}
