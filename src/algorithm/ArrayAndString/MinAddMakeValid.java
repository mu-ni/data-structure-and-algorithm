package algorithm.ArrayAndString;

import java.util.Stack;

public class MinAddMakeValid {
    public static void main(String[] args) {
        System.out.println(new MinAddMakeValid().minAddToMakeValid("())"));
    }

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.size();
    }
}
