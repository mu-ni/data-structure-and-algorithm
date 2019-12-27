package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLength {
    public static void main(String[] args) {
        System.out.println(new MaxLength().maxLength(Arrays.asList("cha","r","act","ers")));
    }

    int max = 0;
    public int maxLength(List<String> arr) {
        backtrack(arr, 0, new ArrayList<>());
        return max;
    }

    public void backtrack(List<String> arr, int start, List<String> path) {
        String str = String.join("", path);
        if (!isValid(str)) return;
        max = Math.max(max, str.length());
        for (int i=start; i<arr.size(); i++) {
            path.add(arr.get(i));
            backtrack(arr, i+1, path);
            path.remove(path.size()-1);
        }
    }

    public boolean isValid(String s) {
        if (s.length() > 26) return false;
        boolean[] arr = new boolean[26];
        for (char c : s.toCharArray()) {
            if (arr[c - 'a']) return false;
            arr[c - 'a'] = true;
        }
        return true;
    }
}
