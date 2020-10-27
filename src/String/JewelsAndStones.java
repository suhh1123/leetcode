package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static int numJewelsIsStones1(String J, String S) {
        HashMap<Character,Integer> countS = new HashMap<>();
        ArrayList<Character> Jlist = new ArrayList<>();
        for (int i=0; i<J.length(); i++) {
            Jlist.add(J.charAt(i));
        }
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            countS.put(c, countS.getOrDefault(c,0)+1);
        }

        int count = 0;
        for (char curr : countS.keySet()) {
            if (Jlist.contains(curr)) {
                count += countS.get(curr);
            }
        }
        return count;
    }

    public static int numJewelsIsStones2(String J, String S) {
        if (S == null || S.length() == 0) return 0;
        int count = 0;
        for (int i=0; i<S.length(); i++) {
            if (J.indexOf(S.charAt(i)) != -1) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String S = "ZZz";
        String J = "z";
        int count = JewelsAndStones.numJewelsIsStones2(J,S);
        System.out.print(count);
    }
}
