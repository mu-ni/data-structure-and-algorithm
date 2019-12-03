package algorithm.StackAndQueue;

import java.util.Stack;

public class RemoveAllAdjDupInString2 {
    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjDupInString2().removeDuplicates("deeedbbcccbdaa", 3));
    }

    public String removeDuplicates(String s, int k) {
        if (k == 1) return "";
        Stack<Character> stack = new Stack<>();
        Stack<Integer> iStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                iStack.push(iStack.peek()+1);
            } else {
                iStack.push(1);
            }
            stack.push(c);
            if (iStack.peek() == k) {
                for (int i = 0; i < k; i++) {
                    stack.pop();
                    iStack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
