package algorithm.TwoPointers.LongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class WithoutRepeating { //Longest Substring without Repeating Character
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
        System.out.println(lengthOfLongestSubstring4("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int max = 0;
        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast));
                fast++;
                max = Math.max(max, fast-slow);
            } else {
                set.remove(s.charAt(slow));
                slow++;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int slow = 0;
        int fast = 0;
        int max = 0;

        while (slow < s.length() && fast < s.length()) {
            String sub = s.substring(slow, fast+1);
            if (!hasDup(sub)) {
                fast ++;
                max = Math.max(max, fast - slow);
                continue;
            }

            slow ++;
        }

        return max;
    }

    public static boolean hasDup(String s) {
        boolean[] arr = new boolean[128];
        for (char c : s.toCharArray()) {
            if (arr[c]) return true;
            arr[c] = true;
        }
        return false;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int[] arr = new int[128];
        int slow = 0;
        int fast = 0;
        int max = 0;
        while (fast < s.length()) {
            if (arr[s.charAt(fast)] == 0) {
                arr[s.charAt(fast)]++;
                fast++;
                max = Math.max(max, fast - slow);
            } else {
                arr[s.charAt(slow)]--;
                slow++;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring4(String s) {
        int slow = 0;
        int fast = 0;
        int len = 0;
        while (fast < s.length()) {
            String sub = s.substring(slow, fast);
            if (sub.indexOf(s.charAt(fast)) < 0) {
                fast++;
                len = Math.max(len, fast - slow);
                continue;
            }
            slow++;
        }
        return len;
    }
}
