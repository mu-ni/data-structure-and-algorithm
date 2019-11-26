package algorithm.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraysKDifferentIntegers {
    public static void main(String[] args) {
        System.out.println(new SubarraysKDifferentIntegers().subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K-1);
    }

    public int atMostK(int[] A, int k) {
        int count = 0;
        int slow = 0;
        int fast = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (fast < A.length) {
            if (map.getOrDefault(A[fast], 0) == 0) k--;
//            if (!map.containsKey(A[fast]) || map.get(A[fast]) == 0) k--;
            map.put(A[fast], map.getOrDefault(A[fast], 0) +1);
            fast++;
            while (k < 0) {
                map.put(A[slow], map.get(A[slow])-1);
                if (map.get(A[slow]) == 0) k++;
                slow++;
            }
            // <=k distinct
            // [1,2,3] add 4 -> [3,4], [2,3,4], [1,2,3,4]
            count += fast - slow;
        }
        return count;
    }
}
