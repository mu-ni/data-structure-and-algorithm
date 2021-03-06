package algorithm.SetAndMap;

import java.util.*;
import java.util.stream.Collectors;

public class MaxOccurrencesSubstring {
    public static void main(String[] args) {
        System.out.println(new MaxOccurrencesSubstring().maxFreq("aababcaab", 2, 3, 4));
        System.out.println(new MaxOccurrencesSubstring().maxFreq("aaaa", 1, 3, 3));
        System.out.println(new MaxOccurrencesSubstring().maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(new MaxOccurrencesSubstring().maxFreq("abcde", 2, 3, 3));
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i=0; i<=s.length() - minSize; i++) {
            String sub = s.substring(i, i+minSize);
            Set<Character> set = sub.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
            if (set.size() > maxLetters) continue;
            int count = map.getOrDefault(sub, 0)+1;
            map.put(sub, count);
            max = Math.max(max, count);
        }
        return max;
    }
}
