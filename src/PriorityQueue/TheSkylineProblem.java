package PriorityQueue;

import java.util.*;

public class TheSkylineProblem {
    public static class Event implements Comparable<Event>{
        int id;
        int x;
        int h;
        int type;

        public Event(int id, int x, int h, int type) {
            this.id = id;
            this.x = x;
            this.h = h;
            this.type = type;
        }

        // sort by x+, type-, h
        @Override
        public int compareTo(Event e) {
            if (x == e.x) {
                // Entering event h from large to small
                // Leaving event h from small to larget
                return e.type * e.h - type * h;
            }
            return x - e.x;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Events
        List<Event> events = new ArrayList<>();
        int id = 0;
        for (int[] curr : buildings) {
            events.add(new Event(id, curr[0], curr[2], 1));
            events.add(new Event(id, curr[1], curr[2], -1));
            id ++;
        }
        Collections.sort(events);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        maxHeap.offer(new int[]{-1, 0});

        Map<Integer, int[]> map = new HashMap<>();

        List<List<Integer>> res = new ArrayList<>();
        for (Event event : events) {
            if (event.type == 1) {
                if (event.h > maxHeap.peek()[1]) {
                    res.add(Arrays.asList(event.x, event.h));
                }
                int[] curr = new int[]{event.id, event.h};
                maxHeap.offer(curr);
                map.put(event.id, curr);
            } else {
                int[] curr = map.get(event.id);
                maxHeap.remove(curr);
                if (event.h > maxHeap.peek()[1]) {
                    res.add(Arrays.asList(event.x, maxHeap.peek()[1]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TheSkylineProblem t = new TheSkylineProblem();
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> res = t.getSkyline(buildings);
        System.out.print(res);
    }
}
