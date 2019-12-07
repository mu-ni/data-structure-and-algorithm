package algorithm.StackAndQueue;

import java.util.Stack;

public class ReverseSubstringsBetweenParentheses {
    public static void main(String[] args) {
        System.out.println(new ReverseSubstringsBetweenParentheses().reverseParentheses("(u(love)i)"));
        System.out.println(new ReverseSubstringsBetweenParentheses().reverseParentheses2("(u(love)i)"));
    }

    // O(n^2)
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                for (char a : sb.toString().toCharArray()) {
                    stack.push(a);
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    // O(n)
    public String reverseParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                int left = stack.pop();
                arr[left] = i;
                arr[i] = left;
            }
        }

        int i = 0;
        int d = 1;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = arr[i];
                d = -d;
            } else {
                sb.append(c);
            }
            i += d;
        }
        return sb.toString();
    }
}
