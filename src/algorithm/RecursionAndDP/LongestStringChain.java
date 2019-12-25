package algorithm.RecursionAndDP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(new LongestStringChain().longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(new LongestStringChain().longestStrChain2(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int rst = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int max = 0;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                max = Math.max(max, map.getOrDefault(sb.toString(), 0) + 1);
            }
            map.put(word, max);
            rst = Math.max(rst, max);
        }
        return rst;
    }

    public int longestStrChain2(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String word : words) {
            int len = 0;
            for (int i = 0; i < word.length(); i++) {
                String pre = word.substring(0, i) + word.substring(i + 1);
                int count = map.getOrDefault(pre, 0) + 1;
                len = Math.max(len, count);
            }
            map.put(word, len);
            max = Math.max(max, len);
        }
        return max;
    }
}
