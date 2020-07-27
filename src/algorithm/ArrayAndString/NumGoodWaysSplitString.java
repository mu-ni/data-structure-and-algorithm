package algorithm.ArrayAndString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by muni on 2020/7/27
 */
public class NumGoodWaysSplitString {
    public static void main(String[] args) {
        System.out.println(new NumGoodWaysSplitString().numSplits("aacaba"));
        System.out.println(new NumGoodWaysSplitString().numSplits2("aacaba"));
    }

    public int numSplits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int rst = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
            int count = map.getOrDefault(c, 0);
            if (count == 0) {
            }if (count == 1) {
                map.remove(c);
            } else {
                map.put(c, count - 1);
            }
            if (map.size() == set.size()) rst++;
        }
        return rst;
    }

    public int numSplits2(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        int l = 0;
        int r = 0;
        int rst = 0;
        for (char c : s.toCharArray()) {
            if (right[c - 'a'] == 0) r++;
            right[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            if (left[c - 'a'] == 0) l++;
            left[c - 'a']++;
            right[c - 'a']--;
            if (right[c - 'a'] == 0) r--;
            if (l == r) rst++;
        }
        return rst;
    }
}
