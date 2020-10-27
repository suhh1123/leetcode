package Stack;

import java.util.Stack;

public class ImplementQueueUsingStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int front;
    public ImplementQueueUsingStack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = stack1.pop();
        if (!stack1.isEmpty()) {
            front = stack1.peek();
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
