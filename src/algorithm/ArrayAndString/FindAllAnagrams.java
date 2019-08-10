package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<=s.length() - p.length(); i++) {
            if (p.indexOf(s.charAt(i)) < 0) continue;
            if (!isAnagram(p, s.substring(i, i+p.length()))) continue;
            list.add(i);
        }
        return list;
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] arr = new int[26];
        for (char c : a.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            if (arr[c - 'a'] <= 0) return false;
            arr[c - 'a']--;
        }
        return true;
    }
}
