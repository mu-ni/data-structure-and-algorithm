package algorithm.SearchAndSort;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestToOrigin {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1,3}, {-2,2}};
        int[][] rst = new KClosestToOrigin().kClosest(points, 1);
        System.out.println(Arrays.deepToString(rst));
    }

    public int[][] kClosest(int[][] points, int K) {
        Comparator<int[]> comparator = (int[] crd1, int[] crd2) -> {
            Double dist1 = Math.pow(crd1[0], 2) + Math.pow(crd1[1], 2);
            Double dist2 = Math.pow(crd2[0], 2) + Math.pow(crd2[1], 2);
            return dist1.compareTo(dist2);
        };

        Arrays.sort(points, comparator);
        return Arrays.copyOfRange(points, 0, K);
    }
}
