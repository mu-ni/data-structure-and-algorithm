package flag.amz;

import java.util.*;

/**
 * Created by muni on 2019/12/9
 */
public class OptimizeMemoryUsage {
    public static void main(String[] args) {
        int[] foregroundTasks = new int[]{1, 7, 2, 4, 5, 6};
        int[] backgroundTasks = new int[]{3, 1, 2};
        System.out.println(Arrays.deepToString(new OptimizeMemoryUsage().optMemoryUsage(foregroundTasks, backgroundTasks, 6)));
        System.out.println(Arrays.deepToString(new OptimizeMemoryUsage().optMemoryUsage(foregroundTasks, backgroundTasks, 10)));
        // TODO （1，2）
    }

    public int[][] optMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int i=0; i<foregroundTasks.length; i++) {
            for (int j=0; j<backgroundTasks.length; j++) {
                pq.offer(new int[]{i, j, foregroundTasks[i] + backgroundTasks[j]});
            }
        }

        List<int[]> rst = new ArrayList<>();
        int max = 0;
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            if (info[2] > k) continue;
            if (max == 0 || max == info[2]) {
                rst.add(new int[]{info[0], info[1]});
                max = info[2];
            } else {
                break;
            }
        }
        return rst.toArray(new int[rst.size()][2]);
    }
}
