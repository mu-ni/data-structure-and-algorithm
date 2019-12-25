package algorithm.SearchAndSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestToOrigin {
    public static void main(String[] args) {
        int[][] points = new int[][]{{3,3}, {5,-1}, {-2,4}};
        System.out.println(Arrays.deepToString(new KClosestToOrigin().kClosest(points, 2)));
        System.out.println(Arrays.deepToString(new KClosestToOrigin().kClosest2(points, 2)));
        System.out.println(Arrays.deepToString(new KClosestToOrigin().kClosest3(points, 2)));
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

    public int[][] kClosest2(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int[] pos : points) {
            int distSquare = (int) (Math.pow(pos[0], 2) + Math.pow(pos[1], 2));
            pq.offer(new int[]{pos[0], pos[1], distSquare});
        }

        int[][] rst = new int[K][2];
        for (int i=0; i<K; i++) {
            int[] info = pq.poll();
            rst[i][0] = info[0];
            rst[i][1] = info[1];
        }
        return rst;
    }

    public int[][] kClosest3(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]); // max - > min
        for (int[] pos : points) {
            int distSquare = (int) (Math.pow(pos[0], 2) + Math.pow(pos[1], 2));
            pq.offer(new int[]{pos[0], pos[1], distSquare});
            if (pq.size() == K+1) {
                pq.poll(); // poll current max value
            }
        }

        int[][] rst = new int[K][2];
        int index = 0;
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            rst[index][0] = info[0];
            rst[index][1] = info[1];
            index++;
        }
        // output reverse order
        return rst;
    }
}
