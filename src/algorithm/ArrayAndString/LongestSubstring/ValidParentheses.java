package algorithm.ArrayAndString.LongestSubstring;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().longestValidParentheses("()(())"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, stack.isEmpty() ? i+1 : i - stack.peek());
                continue;
            }
            stack.push(i);
        }
        return max;
    }
}
