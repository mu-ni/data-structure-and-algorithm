package algorithm.UnionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            if (!map.containsKey(n - 1)) {
                max = Math.max(max, 1);
                map.put(n, 1);
                continue;
            }
            int count = map.get(n - 1) + 1;
            max = Math.max(max, count);
            map.put(n, count);
        }
        return max;
    }

    // TODO union find
}
