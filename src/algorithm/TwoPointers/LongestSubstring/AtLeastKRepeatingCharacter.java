package algorithm.TwoPointers.LongestSubstring;

public class AtLeastKRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring2("bbaaacbd", 3));
        System.out.println(longestSubstring3("bbaaacbd", 3));
    }

    // every character in s appears >= k times
    public static int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        return helper(s, 0, s.length(), k);
    }

    public static int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] arr = new int[26];
        for (int i=start; i<end; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        boolean isValid = true;
        for (int n : arr) {
            if (n == 0) continue;
            if (n < k) isValid = false;
        }
        if (isValid) return end - start;
        for (int i=start; i<end; i++) {
            if (arr[s.charAt(i) - 'a'] >= k) continue;
            return Math.max(helper(s, start, i, k), helper(s,i+1,end,k));
        }
        return 0;
    }

    public static int longestSubstring2(String s, int k) {
        if (s.length() == 0 || s.length() < k) return 0;

        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        boolean isValid = true;
        for (int i : arr) {
            if (i > 0 && i < k) isValid = false;
        }
        if (isValid) return s.length();

        for (int i=0; i<s.length()-1; i++) {
            if (arr[s.charAt(i) - 'a'] >=k) continue;
            String s1 = s.substring(0, i+1);
            String s2 = s.substring(i+1);
            return Math.max(longestSubstring2(s1, k), longestSubstring2(s2, k));
        }
        char last = s.charAt(s.length()-1);
        return arr[last - 'a'] >= k ? s.length() : s.length()-1;
    }

    public static int longestSubstring3(String s, int k) { // brute force
        int len = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {
                String sub = s.substring(i, j);
                if (isValid(sub, k)) {
                    len = Math.max(len, sub.length());
                }
            }
        }
        return len;
    }

    public static boolean isValid(String s, int k) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c] ++;
        }

        for (int n : arr) {
            if (n != 0 && n < k) return false;
        }
        return true;
    }

}
