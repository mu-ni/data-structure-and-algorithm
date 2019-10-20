package algorithm.ArrayAndString.TwoPointers;

public class MinWindowSubString {
    public static void main(String[] args) {
        System.out.println(new MinWindowSubString().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindowSubString().minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindowSubString().minWindow3("ADOBECODEBANC", "ABC"));
    }

    // brute force -> TLE
    public String minWindow(String s, String t) {
        String rst = "";
        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (!isSubStr(sub, t)) continue;
                if (rst.equals("") || sub.length() < rst.length()) {
                    rst = sub;
                }
            }
        }
        return rst;
    }

    // TLE
    public String minWindow2(String s, String t) {
        int slow = 0;
        int fast = 0;
        String rst = "";
        while (slow < s.length() && fast < s.length()) {
            String sub = s.substring(slow, fast+1);
            if (isSubStr(sub, t)) {
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

    public String minWindow3(String s, String t) {
        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        for (char c : t.toCharArray()) {
            arr2[c] ++;
        }

        int slow = 0;
        int fast = 0;
        String rst = "";
        while (slow < s.length() && fast < s.length()) {
            while (fast < s.length() && !contains(arr1, arr2)) {
                arr1[s.charAt(fast)] ++;
                fast++;
            }
            while (slow < s.length() && contains(arr1, arr2)) {
                arr1[s.charAt(slow)] --;
                slow++;
            }
            String sub = s.substring(Math.max(slow-1, 0), fast);
            if (isSubStr(sub, t) && (rst.equals("") || sub.length() < rst.length())) {
                rst = sub;
            }
        }
        return rst;
    }

    public boolean isSubStr(String s1, String s2) {
        if (s2.length() > s1.length()) return false;

        int[] arr = new int[128];
        for (char c : s1.toCharArray()) {
            arr[c] ++;
        }
        for (char c : s2.toCharArray()) {
            arr[c] --;
            if (arr[c] < 0) return false;
        }
        return true;
    }

    public boolean contains(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < arr2[i])
                return false;
        }
        return true;
    }
}
