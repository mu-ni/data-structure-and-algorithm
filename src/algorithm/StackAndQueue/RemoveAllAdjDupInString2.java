package algorithm.StackAndQueue;

import java.util.Stack;

public class RemoveAllAdjDupInString2 {
    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjDupInString2().removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(new RemoveAllAdjDupInString2().removeDuplicates2("deeedbbcccbdaa", 3));
    }

    public String removeDuplicates(String s, int k) {
        if (k == 1) return "";
        Stack<Integer> istack = new Stack<>();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                istack.push(1);
                continue;
            }

            if (stack.peek() == c) {
                istack.push(istack.peek()+1);
            } else {
                istack.push(1);
            }
            stack.push(c);

            if (istack.peek() == k) {
                for (int i=0; i<k; i++) {
                    stack.pop();
                    istack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicates2(String s, int k) {
        if (s.length() == 0 || k == 1) return "";
        String next = helper(s, k);
        while (!s.equals(next)) {
            s = next;
            next = helper(next, k);
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
