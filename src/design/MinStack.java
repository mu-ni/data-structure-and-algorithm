package design;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Queue<Integer> queue;

    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            queue.remove(Integer.valueOf(stack.pop()));
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
