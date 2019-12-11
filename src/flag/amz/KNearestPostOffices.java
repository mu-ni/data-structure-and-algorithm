package flag.amz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by muni on 2019/12/9
 */
public class KNearestPostOffices {
    public static void main(String[] args) {
        int[][] posts = new int[][]{{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}};
        System.out.println(Arrays.deepToString(new KNearestPostOffices().kNearestPostOffices(new int[]{0,0}, posts, 3)));
    }

    // time -> max(O(nlogn), O(k)) -> n = posts.length
    // space -> O(n) -> n = posts.length
    public int[][] kNearestPostOffices(int[] cur, int[][] posts, int k) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
//        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] post : posts) {
            int dist = (post[0] - cur[0])*(post[0] - cur[0]) + (post[1] - cur[1])*(post[1] - cur[1]);
            pq.offer(new int[]{post[0], post[1], dist});
        }

        int[][] rst = new int[k][2];
        for (int i=0; i<k; i++) {
            if (pq.isEmpty()) return rst; // less than k
            int[] info = pq.poll();
            rst[i][0] = info[0];
            rst[i][1] = info[1];
        }
        return rst;
    }

}
