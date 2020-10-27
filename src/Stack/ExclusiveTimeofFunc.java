package Stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunc {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        String[] curr = logs.get(0).split(":");
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(curr[0])); // push id
        int i = 1, prev = Integer.parseInt(curr[2]);
        while (i < logs.size()) {
            String[] s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i ++;
        }
        return res;
    }
}
