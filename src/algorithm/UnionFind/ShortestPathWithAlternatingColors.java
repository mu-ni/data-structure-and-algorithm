package algorithm.UnionFind;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        int[][] red_edges = new int[][]{{0,1},{0,2}};
        int[][] blue_edges = new int[][]{{1,0}};
        System.out.println(Arrays.toString(new ShortestPathWithAlternatingColors().shortestAlternatingPaths(3, red_edges, blue_edges)));
    }

    //1=red, 2=blue, 0=root-edge (special case)
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        for (int[] edge : red_edges) {
            redMap.putIfAbsent(edge[0], new ArrayList<>());
            redMap.get(edge[0]).add(edge[1]);
        }
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] edge : blue_edges) {
            blueMap.putIfAbsent(edge[0], new ArrayList<>());
            blueMap.get(edge[0]).add(edge[1]);
        }

        int[] rst = new int[n];
        Arrays.fill(rst, -1);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        Set<String> set = new HashSet<>();
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] pos = queue.poll();
                if (set.contains(Arrays.toString(pos))) continue;
                set.add(Arrays.toString(pos));
                int x = pos[0];
                int y = pos[1];

                if (rst[x] == -1) {
                    rst[x] = dist;
                }
                if (y == 0 || y == 2) {
                    for (int red : redMap.getOrDefault(x, new ArrayList<>())) {
                        queue.add(new int[]{red, 1});
                    }
                }
                if (y == 0 || y == 1) {
                    for (int blue : blueMap.getOrDefault(x, new ArrayList<>())) {
                        queue.add(new int[]{blue, 2});
                    }
                }
            }
            dist++;
        }

        return rst;
    }
}
