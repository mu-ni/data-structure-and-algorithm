package algorithm.ArrayAndString;

import java.util.Stack;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) { // brute force
        String rst = "";
        for (int i=0; i<s.length(); i++) {
            String substr = s.substring(i, s.length());
            for (int j=0; j<s.length(); j++) {
                if (!isPalindrome(substr)) {
                    substr = substr.substring(0, substr.length()-1);
                }
            }
            rst = substr.length() > rst.length() ? substr : rst;
        }
        return rst;
    }

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        for (char c : s.toCharArray()) {
            if (stack.pop() != c) return false;
        }
        return true;
    }
}
