package algorithm.Greedy;

import java.util.*;

/**
 * Created by muni on 2020/7/23
 */
public class MaxNumNonOverlappingSubstrings {
    public static void main(String[] args) {
        System.out.println(new MaxNumNonOverlappingSubstrings().maxNumOfSubstrings("adefaddaccc"));
        System.out.println(new MaxNumNonOverlappingSubstrings().maxNumOfSubstrings("abab"));
        System.out.println(new MaxNumNonOverlappingSubstrings().maxNumOfSubstrings("cabcccbaa"));
    }

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            first[s.charAt(i) - 'a'] = i;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int left = first[i];
            int right = last[i];
            // extend range for all chars inside
            // left & right are changing
            for (int j = left; j <= right; j++) {
                int index = s.charAt(j) - 'a';
                left = Math.min(left, first[index]);
                right = Math.max(right, last[index]);
            }
            if (left == first[i]) {
                list.add(new int[]{left, right});
            }
        }

        list.sort(Comparator.comparingInt(o -> o[1]));
        List<String> rst = new ArrayList<>();
        int end = -1;
        for (int[] l : list) {
            if (l[0] <= end) continue;
            rst.add(s.substring(l[0], l[1]+1));
            end = l[1];
        }
        return rst;
    }
}
