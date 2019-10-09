package algorithm.ArrayAndString.LongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class AtMostKTypesCharacter {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(lengthOfLongestSubstringKDistinct2("eceba", 2));
    }

    // character types <= k
    // TLE
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int slow = 0;
        int fast = 0;
        int max = 0;
        while(fast < s.length()) {
            int types = getTypes(s, slow, fast);
            if (types <= k) {
                fast++;
                max = Math.max(max, fast-slow);
            } else {
                slow++;
            }
        }
        return max;
    }

    public static int getTypes(String s, int slow, int fast) {
        Set<Character> set = new HashSet<>();
        for (int i=slow; i<=fast; i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }

    public static int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int[] arr = new int[128];
        int slow = 0;
        int fast = 0;
        int max = 0;
        int types = 0;
        while (fast < s.length()) {
            if (arr[s.charAt(fast)] == 0) {
                types++;
            }
            arr[s.charAt(fast)]++;
            fast++;
            if (types <= k) {
                max = Math.max(max, fast - slow);
            } else {
                arr[s.charAt(slow)]--;
                if (arr[s.charAt(slow)] == 0) {
                    types--;
                }
                slow++;
            }
        }
        return max;
    }
}
