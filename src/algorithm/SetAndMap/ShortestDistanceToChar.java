package algorithm.SetAndMap;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by muni on 2020/1/17
 */
public class ShortestDistanceToChar {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShortestDistanceToChar().shortestToChar("loveleetcode", 'e')));
    }

    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<n; i++) {
            if (S.charAt(i) == C) set.add(i);
        }

        int[] rst = new int[n];
        for (int i=0; i<n; i++) {
            Integer ceil = set.ceiling(i);
            Integer floor = set.floor(i);
            if (ceil == null || floor == null) {
                rst[i] = ceil == null ? i - floor : ceil - i;
            } else {
                rst[i] = Math.min(ceil - i, i - floor);
            }
        }
        return rst;
    }
}
