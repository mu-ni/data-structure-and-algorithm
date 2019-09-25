package algorithm.ArrayAndString;

import java.util.*;

public class SkylineProblem {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{5,20,10},{19,24,8}};
        System.out.println(new SkylineProblem().getSkyline(buildings));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        List<List<Integer>> rst = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        pq.offer(0);
        int pre = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (cur != pre) {
                rst.add(Arrays.asList(h[0], cur));
                pre = cur;
            }
        }
        return rst;
    }
}
