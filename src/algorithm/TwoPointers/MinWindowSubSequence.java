package algorithm.TwoPointers;

public class MinWindowSubSequence {
    public static void main(String[] args) {
        System.out.println(new MinWindowSubSequence().minWindow("abcdebdde", "bde"));
    }

    public String minWindow(String S, String T) {
        int slow = 0;
        int fast = 0;
        String rst = "";
        while (fast < S.length()) {
            String sub = S.substring(slow, fast+1);
            if (isSubSequence(sub, T)) {
                if (rst.equals("") || sub.length() < rst.length()) {
                    rst = sub;
                }
                slow++;
            } else {
                fast++;
            }
        }
        return rst;
    }

    public boolean isSubSequence(String s1, String s2) {
        if (s2.length() > s1.length()) return false;
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.length()) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                i1++;
                i2++;
                if (i2 == s2.length()) return true;
            } else {
                i1++;
            }
        }
        return false;
    }
}
