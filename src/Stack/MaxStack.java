package Stack;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (x > max) maxStack.push(x);
        else maxStack.push(max);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> tmp = new Stack<>();
        while (stack.peek() != max) {
            tmp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while (!tmp.isEmpty()) {
            int x = tmp.pop();
            push(x);
        }
        return max;
    }
}
