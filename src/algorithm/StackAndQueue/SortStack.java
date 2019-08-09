package algorithm.StackAndQueue;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(8);
        stack.push(1);
        stack.push(6);
        stack.push(5);
        stack.push(1);

        Stack<Integer> sortedStack = sortStack(stack);
        System.out.println(sortedStack.toString());
    }

    public static Stack sortStack(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();

        while(!stack.empty()) {
            if (sortedStack.isEmpty() || stack.peek() >= sortedStack.peek()) {
                sortedStack.push(stack.pop());
                continue;
            }
            int tmp = stack.pop();
            while(!sortedStack.empty() && sortedStack.peek() > tmp) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(tmp);
        }

        return sortedStack;
    }
}
