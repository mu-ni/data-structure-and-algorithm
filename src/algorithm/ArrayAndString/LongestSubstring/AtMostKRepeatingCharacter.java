package algorithm.ArrayAndString.LongestSubstring;

public class AtMostKRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(longestSubstring("abcbbb", 3));
    }

    // every character in s appears <= k times
    public static int longestSubstring(String s, int k) { // not fully tested
        int slow = 0;
        int fast = k-1;
        int max = 0;
        while (slow < s.length() && fast < s.length()) {
            String sub = s.substring(slow, fast+1);
            if (isValid(sub, k)) {
                fast++;
                max = Math.max(max, fast-slow);
                continue;
            }
            slow++;
        }
        return max;
    }

    public static boolean isValid(String s, int k) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a'] ++;
        }
        for (int i : arr) {
            if (i > k) return false;
        }
        return true;
    }
}
