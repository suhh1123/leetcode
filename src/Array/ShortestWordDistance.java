package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestWordDistance {
    // for each word1, we need to get the recent position p1
    // for each word2, we need to get the recent position p2
    // Assume word1 is not equals to word2
    public static int shortestDistance1(String[] words, String word1, String word2) {
        // corner case
        // word1 or word2 is invalid in words (maybe)
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            } else if (words[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static int shortestDistance2(String[] words, String word1, String word2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) l1.add(i);
            else if (words[i].equals(word2)) l2.add(i);
        }
        int p1 = 0, p2 = 0;
        int res = Integer.MAX_VALUE;
        while (p1 < l1.size() && p2 < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(p1) - l2.get(p2)));
            if (l1.get(p1) < l2.get(p2)) p1 ++;
            else p2 ++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        int shortestDistance = shortestDistance2(words, word1, word2);
        System.out.println(shortestDistance);
    }
}
