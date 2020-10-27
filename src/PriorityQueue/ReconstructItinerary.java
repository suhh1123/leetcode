package PriorityQueue;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary1(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (int i = 0; i < tickets.size(); i++) {
            if (!map.containsKey(tickets.get(i).get(0))) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(tickets.get(i).get(0), pq);
            }
            map.get(tickets.get(i).get(0)).offer(tickets.get(i).get(1));
        }

        dfs("JFK", res, map);
        return res;
    }

    private void dfs(String s, LinkedList<String> res, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> pq = map.get(s);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), res, map);
        }

        res.addFirst(s);
    }

    public List<String> findItinerary2(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) return null;

        int totalLen = tickets.size() + 1;

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            if (!map.containsKey(tickets.get(i).get(0))) {
                map.put(tickets.get(i).get(0), new ArrayList<>());
            }
            map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }

        for (List<String> list : map.values()) {
            Collections.sort(list);
        }

        String start = "JFK";
        List<String> res = new ArrayList<>();
        res.add(start);
        if (find(start, res, map, totalLen)) {
            return res;
        }
        return null;
    }

    private boolean find(String start, List<String> res, Map<String, List<String>> map, int totalLen) {
        if (res.size() == totalLen) return true;

        if (!map.containsKey(start)) return false;

        List<String> destinations = map.get(start);

        for (int i = 0; i < destinations.size(); i++) {
            String des = destinations.get(i);
            destinations.remove(i);
            res.add(des);
            if (find(des, res, map, totalLen)) {
                return true;
            }
            res.remove(res.size() - 1);
            destinations.add(i, des);
        }
        return false;
    }

    public static void main(String[] args) {
        ReconstructItinerary r = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();
        l1.add("JFK");
        l1.add("KUL");
        l2.add("JFK");
        l2.add("NRT");
        l3.add("NRT");
        l3.add("JFK");
        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);
        List<String> res = r.findItinerary2(tickets);
    }
}
