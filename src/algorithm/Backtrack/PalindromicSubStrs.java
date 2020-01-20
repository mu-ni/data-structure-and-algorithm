package algorithm.Backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        backtrack(s.toCharArray(), 0, new ArrayList<>(), new HashMap<>());
        return count;
    }

    private void backtrack(char[] arr, int start, List<Character> path, Map<String, Boolean> map) {
        String str = buildStr(path);
        if (map.containsKey(str)) {
            if (map.get(str)) {
                count++;
            }
            return;
        }
        map.put(str, isPalindrome(str));
        for (int i=start; i<arr.length; i++) {
            path.add(arr[i]);
            backtrack(arr, i+1, path, map);
            path.remove(path.size()-1);
        }
    }

    private String buildStr(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
