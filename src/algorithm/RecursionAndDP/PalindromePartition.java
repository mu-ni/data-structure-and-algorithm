package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<>();
        backtrack(rst, s, 0, new ArrayList<>());
        return rst;
    }

    public static void backtrack(List<List<String>> rst, String s, int start, List<String> path) {
        if (start == s.length()) {
            rst.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<s.length(); i++) {
            if (!isPalindrome(s.toCharArray(), start, i)) continue;
            path.add(s.substring(start, i+1));
            backtrack(rst, s, i+1, path);
            path.remove(path.size()-1);
        }
    }

    public static boolean isPalindrome(char[] arr, int left, int right) {
        while (left <= right) {
            if (arr[left] != arr[right]) return false;
            left ++;
            right --;
        }
        return true;
    }
}
