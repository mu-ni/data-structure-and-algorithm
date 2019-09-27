package algorithm.ArrayAndString.LongestSubstring;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().longestValidParentheses(")()()"));
        System.out.println(new ValidParentheses().longestValidParentheses2(")()()"));
        System.out.println(new ValidParentheses().longestValidParentheses3(")()()"));
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

    // brute force TLE
    public int longestValidParentheses3(String s) {
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (isValid(sub)) {
                    max = Math.max(max, sub.length());
                }
            }
        }
        return max;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
