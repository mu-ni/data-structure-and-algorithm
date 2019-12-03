package algorithm.RecursionAndDP;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestArithmeticSubsequence().longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int rst = 0;
        for (int n : arr) {
            int count = map.getOrDefault(n - difference, 0) + 1;
            map.put(n, count);
            rst = Math.max(rst, count);
        }
        return rst;
    }
}
