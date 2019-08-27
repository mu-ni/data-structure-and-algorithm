package algorithm.ArrayAndString.LongestSubstring;

public class AtMostKTypesCharacter {
    public static void main(String[] args) {
        System.out.println(longestSubstring("ababc", 3));
        System.out.println(longestSubstring("abcab", 3));
    }

    // character types < k
    public static int longestSubstring(String s, int k) { // not fully tested
        int slow = 0;
        int fast = 0;
        int max = 0;
        while(slow < s.length() && fast < s.length()) {
            String sub = s.substring(slow, fast+1);
            if (isValid(sub, k)) {
                fast++;
                max = Math.max(max, fast - slow);
                continue;
            }
            slow++;
        }
        return max;
    }

    public static boolean isValid(String s, int k) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        int types = 0;
        for (int i : arr) {
            if (i != 0) types++;
            if (types >= k) return false;
        }
        return true;
    }
}
