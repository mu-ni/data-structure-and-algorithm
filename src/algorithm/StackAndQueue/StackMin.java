package algorithm.StackAndQueue;

import java.util.Stack;

public class StackMin extends Stack {
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        if (minStack.empty() || val < minStack.peek()) {
            minStack.push(val);
        }
        super.push(val);
    }

    public Object pop() {
        if (!minStack.empty() && super.peek() == minStack.peek()) {
            minStack.pop();
        }
        return super.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
