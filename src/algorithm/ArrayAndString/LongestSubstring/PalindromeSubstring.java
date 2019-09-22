package algorithm.ArrayAndString.LongestSubstring;

import java.util.Stack;

public class PalindromeSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome2("babad"));
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
        if (s.length() <= 1) return s;
        String rst = "";
        for (int i=1; i<s.length(); i++) {
            String s1 = expand(s, i, i);
            String s2 = expand(s, i-1, i);
            int max = Math.max(s1.length(), s2.length());
            if (max > rst.length()) {
                rst = s1.length() == max ? s1 : s2;
            }
        }
        return rst;
    }

    public static String expand(String s, int slow, int fast) {
        while (slow >= 0 && fast < s.length()) {
            if (s.charAt(slow) != s.charAt(fast)) break;
            slow--;
            fast++;
        }
        return s.substring(slow+1, fast);
    }
}
