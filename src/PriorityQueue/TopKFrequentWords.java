package PriorityQueue;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> map.get(s1) == map.get(s2) ? s1.compareTo(s2) : map.get(s2) - map.get(s1));
        for (String key : map.keySet()) {
            pq.offer(key);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
