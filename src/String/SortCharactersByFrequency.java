package String;

import java.util.*;

public class SortCharactersByFrequency {
    public static String frequencySort1(String s) {
        HashMap<Character,Integer> count = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> count.get(b) - count.get(a));
        for (char c : count.keySet()) {
            pq.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i=0; i<count.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String frequencySort2(String s) {
        HashMap<Character,Integer> count = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        List<Character> chars = new ArrayList<>(count.keySet());
        Collections.sort(chars,(a,b) -> count.get(b) - count.get(a));

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            for (int i=0; i<count.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();


    }

    public static void main(String[] args) {
        String s = "tree";
        String result = SortCharactersByFrequency.frequencySort2(s);
        System.out.println(result);
    }
}
