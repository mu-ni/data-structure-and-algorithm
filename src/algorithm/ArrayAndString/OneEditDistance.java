package algorithm.ArrayAndString;

public class OneEditDistance {
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("abc", "aBc"));
        System.out.println(isOneEditDistance("abc", "ab"));
    }

    public static boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            arr[c] ++;
        }
        for(char c : t.toCharArray()) {
            arr[c] --;
        }

        int diff = 0;
        for(int i : arr) {
            if(i == 0) continue;
            diff += Math.abs(i);
        }
        return diff == 1 || diff == 2;
    }
}
