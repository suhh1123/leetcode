package PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            if (!map.containsKey(flights[i][0])) {
                map.put(flights[i][0], new ArrayList<>());
            }
            map.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        findPath(src, dst, 0, map, K, -1);
        return pq.isEmpty() ? -1 : pq.poll();
    }

    private void findPath(int src, int dst, int price, Map<Integer, ArrayList<int[]>> map, int k, int stop) {
        if (!pq.isEmpty() && price > pq.peek()) return;
        if (stop > k) return;
        if (src == dst && stop <= k) {
            pq.offer(price);
            return;
        }
        if (!map.containsKey(src)) {
            return;
        }
        ArrayList<int[]> destinations = map.get(src);
        for (int i = 0; i < destinations.size(); i++) {
            int[] des = destinations.get(i);
            destinations.remove(i);
            findPath(des[0], dst, price + des[1], map, k, stop + 1);
            destinations.add(i, des);
        }
    }
}
