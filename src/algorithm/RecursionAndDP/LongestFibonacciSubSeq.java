package algorithm.RecursionAndDP;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by muni on 2020/1/20
 */
public class LongestFibonacciSubSeq {
    public static void main(String[] args) {
        System.out.println(new LongestFibonacciSubSeq().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i];
                int b = A[j];
                if (!set.contains(a + b)) continue;
                int len = 2;
                while (set.contains(a + b)) {
                    int sum = a + b;
                    a = b;
                    b = sum;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
