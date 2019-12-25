package algorithm.ArrayAndString.BoyerMoore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementIn2NArray {
    public static void main(String[] args) {
        System.out.println(new NRepeatedElementIn2NArray().repeatedNTimes(new int[]{2,1,2,5,3,2}));
        System.out.println(new NRepeatedElementIn2NArray().repeatedNTimes2(new int[]{2,1,2,5,3,2}));
    }

    // appear >= len/2 -> can't use boyer-moore
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            int count = map.getOrDefault(n, 0) + 1;
            if (count >= A.length/2) return n;
            map.put(n, count);
        }
        return -1;
    }

    // len is 2N, N+1 unique
    // 3,3,5,9
    // 1,2,3,3
    public int repeatedNTimes2(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        if (A[n/2] == A[n/2+1]) return A[n/2];
        return A[n/2-1];
    }
}
