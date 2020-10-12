package algorithm.StackAndQueue;

import java.util.Stack;

/**
 * Created by muni on 2020/10/12
 */
public class RemoveDuplicatedLetters {
    public static void main(String[] args) {
//        System.out.println(new RemoveDuplicatedLetters().removeDuplicateLetters("bcabc"));
        System.out.println(new RemoveDuplicatedLetters().removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        for (char c : arr) count[c - 'a']++;
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (char c : arr) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty()
                    && stack.peek() > c
                    && count[stack.peek() - 'a'] > 0) { // exist stack.peek() behind
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            visited[c - 'a'] = true;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
