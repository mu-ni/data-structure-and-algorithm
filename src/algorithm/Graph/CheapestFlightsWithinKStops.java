package algorithm.Graph;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(3, flights, 0, 2, 1));
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice2(3, flights, 0, 2, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            int key = flight[0];
            map.putIfAbsent(key, new HashMap<>());
            map.get(key).put(flight[1], flight[2]);
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.offer(new int[]{src, 0, K});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int city = cur[0];
            int price = cur[1];
            int stop = cur[2];
            if (city == dst) return price;
            if (stop < 0 || stop > n) continue;
            if (map.containsKey(city)) {
                for (int next : map.get(city).keySet()) {
                    queue.offer(new int[]{next, price + map.get(city).get(next), stop-1});
                }
            }
        }

        return -1;
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new HashMap<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{src, 0, K});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int city = cur[0];
            int price = cur[1];
            int stop = cur[2];
            if (city == dst) return price;
            if (stop < 0 || stop > n) continue;
            for (int next : graph.get(city).keySet()) {
                queue.offer(new int[]{next, price + graph.get(city).get(next), stop-1});
            }
        }

        return -1;
    }
}
