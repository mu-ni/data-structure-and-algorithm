package algorithm.Math;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(new MaxPoints().maxPoints(points));
        System.out.println(new MaxPoints().maxPoints2(points));
    }

    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int rst = 0;
        for (int i=0; i<points.length-1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int overlap = 0;
            int lineMax = 0;
            for (int j=i+1; j<points.length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                String key = generateKey(x, y);
                map.put(key, map.getOrDefault(key, 0) +1);
                lineMax = Math.max(lineMax, map.get(key));
            }
            rst = Math.max(rst, lineMax + overlap + 1);
        }

        return rst;
    }

    private String generateKey(int x, int y) {
        int gcd = generateGcd(x, y);
        x /= gcd;
        y /= gcd;
        return y + "/" + x;
    }

    private int generateGcd(int x, int y) {
        if (y == 0) return x;
        return generateGcd(y, x % y);
    }

    // wrong answer
    // [[2,3],[3,3],[-5,3]] -> output 2 -> expected 3
    public int maxPoints2(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        for (int i=0; i<points.length-1; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int overlap = 0;
            int lineMax = 0;
            for (int j=i+1; j<points.length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                double key = (double)y/x;
                int val = map.getOrDefault(key, 0) + 1;
                lineMax = Math.max(lineMax, val);
                map.put(key, val);
            }
            max = Math.max(max, lineMax + overlap + 1);
        }
        return max;
    }
}
