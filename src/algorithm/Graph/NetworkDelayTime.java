package algorithm.Graph;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(new NetworkDelayTime().networkDelayTime(times, 4, 2));
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.offer(new int[]{K, 0});
        boolean[] visited = new boolean[N+1];
        int index = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int dist = cur[1];
            if (visited[node]) continue;
            visited[node] = true;
            index++;
            if (index == N) return dist;
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    queue.add(new int[]{next, dist + map.get(node).get(next)});
                }
            }
        }

        return -1;
    }
}
