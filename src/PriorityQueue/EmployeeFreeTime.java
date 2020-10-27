package PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    public static class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        for (List<Interval> list : schedule) {
            for (Interval i : list) {
                pq.offer(i);
            }
        }

        List<Interval> res = new ArrayList<>();
        int max_end = -1;
        while (!pq.isEmpty()) {
            Interval curr = pq.poll();
            if (max_end != -1 && curr.start > max_end) {
                res.add(new Interval(max_end, curr.start));
            }
            max_end = Math.max(max_end, curr.end);
        }
        return res;
    }
}
