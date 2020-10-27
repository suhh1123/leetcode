package Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        int i = 1;
        while (i < S.length()) {
            if (!stack.isEmpty()) {
                if (S.charAt(i) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString r = new RemoveAllAdjacentDuplicatesInString();
        String S = "abbaca";
        String res = r.removeDuplicates(S);
        System.out.print(res);
    }
}
