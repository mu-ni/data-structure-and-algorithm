package algorithm.StackAndQueue;

import java.util.Stack;

public class QueueViaStacks {
    Stack<Integer> stack1 = new Stack<>(); // in sequence
    Stack<Integer> stack2 = new Stack<>(); // for reverse

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void add(int val) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(val);
    }

    public int peak() {
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public int remove() {
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
