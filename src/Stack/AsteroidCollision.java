package Stack;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0 && Math.abs(stack.peek()) <= Math.abs(asteroids[i])) {
                    prev = stack.pop();
                    if (Math.abs(prev) == Math.abs(asteroids[i])) break;
                }
                if (Math.abs(prev) != Math.abs(asteroids[i]) && (stack.isEmpty() || stack.peek() < 0)) {
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
        }
        int[] res = new int[stack.size()];
        int i = res.length - 1;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i --;
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision a = new AsteroidCollision();
        int[] asteroids = {8, -8};
        int[] res = a.asteroidCollision(asteroids);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
