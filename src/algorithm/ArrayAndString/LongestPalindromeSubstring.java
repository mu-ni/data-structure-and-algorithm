package algorithm.ArrayAndString;

import java.util.Stack;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));

        System.out.println(longestPalindrome2("a"));
        System.out.println(longestPalindrome2("bb"));
        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("cbbd"));
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
        if (s.length() <=1) return s;
        String rst = "";
        for (int i=0; i<s.length(); i++) {
            String s2 = expandAroundCenter(s, i, i+1);
            String s1 = expandAroundCenter(s, i, i);
            int max = Math.max(s1.length(), s2.length());
            if (max > rst.length()) {
                rst = s1.length() > s2.length() ? s1 : s2;
            }
        }
        return rst;
    }

    public static String expandAroundCenter(String s, int start, int end) {
        int left = start;
        int right = end;
        while(left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // now left < 0 or right > s.length()
        // get previous substring
        return s.substring(left+1,right);
    }
}
