package algorithm.ArrayAndString.LongestSubstring;

import java.util.Stack;

public class PalindromeSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome2("a"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <=1) return s;
        String rst = "";
        for (int i=0; i<=s.length(); i++) {
            for (int j=i; j<=s.length();j++) {
                String str = s.substring(i,j);
                if (isPalindrome(str) && str.length() > rst.length()) {
                    rst = str;
                }
            }
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

    public static String longestPalindrome2(String s) {
        String rst = "";
        for (int i=0; i<s.length(); i++) {
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i+1);
            String longer = s1.length() >= s2.length() ? s1:s2;
            rst = longer.length() >= rst.length() ? longer:rst;
        }
        return rst;
    }

    public static String expand(String s, int c1, int c2) {
        while (c1 >=0 && c2 < s.length() && s.charAt(c1) == s.charAt(c2)) {
            c1--;
            c2++;
        }
        return s.substring(c1+1, c2);
    }
}
