package algorithm.Backtrack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by muni on 2020/1/20
 */
public class PalindromicSubStrs {
    public static void main(String[] args) {
        System.out.println(new PalindromicSubStrs().countSubstrings("aaa"));
    }

    int count = 0;
    public int countSubstrings(String s) {
        backtrack(s.toCharArray(), 0, new StringBuilder(), new HashMap<>());
        return count;
    }

    private void backtrack(char[] arr, int start, StringBuilder path, Map<String, Boolean> map) {
        String str = path.toString();
        System.out.println(str);
        if (map.containsKey(str)) {
            if (map.get(str)) count++;
            return;
        }
        map.put(str, isPalindrome(str));
        for (int i=start; i<arr.length; i++) {
            path.append(arr[i]);
            backtrack(arr, i+1, path, map);
            path = new StringBuilder(path.substring(0, path.length()-1));
        }
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}
