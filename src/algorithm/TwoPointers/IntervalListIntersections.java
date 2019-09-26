package algorithm.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] A = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(new IntervalListIntersections().intervalIntersection(A, B)));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> rst = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);

            if (start <= end) {
                rst.add(new int[]{start, end});
            }

            if (A[i][1] == end) i++;
            if (B[j][1] == end) j++;
        }
        return rst.toArray(new int[rst.size()][2]);
    }
}
