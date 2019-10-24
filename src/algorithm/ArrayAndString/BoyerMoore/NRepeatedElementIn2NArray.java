package algorithm.ArrayAndString.BoyerMoore;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementIn2NArray {
    public static void main(String[] args) {
        System.out.println(new NRepeatedElementIn2NArray().repeatedNTimes2(new int[]{2,1,2,5,3,2}));
    }

    // appear >= len/2 -> can't use boyer-moore
    public int repeatedNTimes2(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            int count = map.getOrDefault(n, 0) + 1;
            if (count >= A.length/2) return n;
            map.put(n, count);
        }
        return -1;
    }
}
