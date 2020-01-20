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
        System.out.println(new PalindromicSubStrs().countSubstrings("aba"));
        System.out.println(new PalindromicSubStrs().countSubstrings2("aba"));
        System.out.println(new PalindromicSubStrs().countSubstrings3("aba"));
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (new StringBuilder(sub).reverse().toString().equals(sub)) count++;
            }
        }
        return count;
    }

    public int countSubstrings2(String s) {
        Map<String, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=i; j<s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (map.containsKey(sub)) {
                    if (map.get(sub)) count++;
                    continue;
                }
                boolean isValid = new StringBuilder(sub).reverse().toString().equals(sub);
                map.put(sub, isValid);
                if (isValid) count++;
            }
        }
        return count;
    }

    int count = 0;
    public int countSubstrings3(String s) {
        for (int i=0; i<s.length(); i++) {
            expandFromCenter(s, i, i);
            expandFromCenter(s, i, i+1);
        }
        return count;
    }

    private void expandFromCenter(String s, int i1, int i2) {
        while (i1 >= 0 && i2 < s.length() && s.charAt(i1) == s.charAt(i2)) {
            count++;
            i1--;
            i2++;
        }
    }
}
