package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");
        Set<String> banWords = new HashSet<>();
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : banned) {
            banWords.add(s);
        }
        for (String word : words) {
            count.put(word, count.getOrDefault(word,0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> count.get(b) - count.get(a));
        for (String key : count.keySet()) {
            pq.add(key);
        }

        while (!pq.isEmpty()) {
            String curr = pq.poll();
            if (!banWords.contains(curr)) {
                return curr;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        String result = MostCommonWord.mostCommonWord(paragraph, banned);
        System.out.print(result);
    }
}
