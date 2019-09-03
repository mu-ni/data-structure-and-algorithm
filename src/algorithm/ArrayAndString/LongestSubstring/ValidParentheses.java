package algorithm.ArrayAndString.LongestSubstring;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().longestValidParentheses(")()()"));
        System.out.println(new ValidParentheses().longestValidParentheses2(")()()"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, stack.isEmpty() ? i + 1 : i - stack.peek());
                continue;
            }
            stack.push(i);
        }
        return max;
    }

    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            int prevLeft = i - dp[i - 1] - 1;
            if (s.charAt(i) == ')' && prevLeft >= 0 && s.charAt(prevLeft) == '(') {
                int prevLen = prevLeft - 1 >= 0 ? dp[prevLeft - 1] : 0;
                dp[i] = dp[i - 1] + 2 + prevLen;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
