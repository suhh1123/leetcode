package Stack;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if (size == k) return "0";
        Stack<Character> stack = new Stack<>();
        int count = 0;
        while (count < size) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(count)) {
                stack.pop();
                k --;
            }
            stack.push(num.charAt(count));
            count ++;
        }
        while (k > 0) {
            stack.pop();
            k --;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
