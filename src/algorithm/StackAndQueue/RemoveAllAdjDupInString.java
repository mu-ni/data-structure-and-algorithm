package algorithm.StackAndQueue;

import java.util.Stack;

/**
 * Created by muni on 2019/12/26
 */
public class RemoveAllAdjDupInString {
    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjDupInString().removeDuplicates("abbaca"));
        System.out.println(new RemoveAllAdjDupInString().removeDuplicates2("aaaaaaaa"));
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicates2(String s) {
        if (s.length() == 0) return "";
        String next = helper(s, 2);
        while (!s.equals(next)) {
            s = next;
            next = helper(next, 2);
        }
        return next;
    }

    // one round
    private String helper(String s, int k) {
        if (s.length() == 0) return "";
        char[] arr = s.toCharArray();
        char c = arr[0];
        int count = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] == c) {
                count++;
                if (count == k) {
                    for (int j=i; j>i-k; j--) {
                        arr[j] = '#';
                    }
                    count = 0;
                }
            } else {
                c = arr[i];
                count = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char a : arr) {
            if (!Character.isLetter(a)) continue;
            sb.append(a);
        }
        return sb.toString();
    }
}
