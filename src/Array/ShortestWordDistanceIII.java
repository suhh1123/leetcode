package Array;

public class ShortestWordDistanceIII {
    // word1 and word2 can be equal
    public static int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int p1 = -1, p2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2)) {
                if (words[i].equals(word1)) {
                    if (p1 <= p2) p1 = i;
                    else p2 = i;
                }
            } else {
                if (words[i].equals(word1)) {
                    p1 = i;
                } else if (words[i].equals(word2)) {
                    p2 = i;
                }
            }
            if (p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "perfect";
        String word2 = "perfect";
        int shortestDistance = shortestDistance(words, word1, word2);
        System.out.println(shortestDistance);
    }
}
