package algorithm.ArrayAndString.LongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class WithoutRepeating { //Longest Substring without Repeating Character
    public static void main(String[] args) {
        System.out.println(longestSubstring("pwwkew"));
    }

    public static int longestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int len = 0;
        Set<Character> set = new HashSet<>();

        while(slow < s.length() && fast < s.length()) {
            char c = s.charAt(fast);
            if(set.contains(c)) {
                set.remove(s.charAt(slow));
                slow++;
                continue;
            }
            set.add(c);
            fast++;
            len = Math.max(len, fast-slow);
        }

        return len;
    }
}
