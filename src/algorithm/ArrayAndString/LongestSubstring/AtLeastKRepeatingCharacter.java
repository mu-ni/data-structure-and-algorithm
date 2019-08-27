package algorithm.ArrayAndString.LongestSubstring;

public class AtLeastKRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }

    // every character in s appears >= k times
    public static int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    public static int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] arr = new int[26];
        for (int i = start; i<end; i++) {
            arr[str[i] - 'a']++;
        }
        for (int i = start; i<end; i++) {
            if (arr[str[i] - 'a'] >=k) continue;
            return Math.max(helper(str, start, i, k), helper(str,i+1,end,k));
        }
        return end - start;
    }
}
