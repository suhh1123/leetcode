package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistanceII {
    public HashMap<String, ArrayList<Integer>> map;
    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortestDistance(String word1, String word2) {
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);

        int res = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        while (p1 < l1.size() && p2 < l2.size()) {
            res = Math.min(Math.abs(l1.get(p1) - l2.get(p2)), res);
            if (l1.get(p1) < l2.get(p2)) {
                p1 ++;
            } else {
                p2 ++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
