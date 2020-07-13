package algorithm.DFS;

import java.util.*;

/**
 * Created by muni on 2020/7/13
 */
public class PathWithMaxProbability {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{0,2}};
        double[] succProb = new double[]{0.5,0.5,0.2};
        System.out.println(new PathWithMaxProbability().maxProbability(3, edges, succProb, 0, 2));
        System.out.println(new PathWithMaxProbability().maxProbability2(3, edges, succProb, 0, 2));
        System.out.println(new PathWithMaxProbability().maxProbability3(3, edges, succProb, 0, 2));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i=0; i<edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(new int[]{edges[i][1], i});
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(new int[]{edges[i][0], i});
        }

        double[] p = new double[n];
        p[start] = 1d;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] a : graph.getOrDefault(cur, Collections.emptyList())) {
                int next = a[0];
                int index = a[1];
                if (p[cur]*succProb[index] > p[next]) {
                    p[next] = p[cur]*succProb[index];
                    queue.offer(next);
                }
            }
        }
        return p[end];
    }

    public double maxProbability2(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i=0; i<edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }

        double[] p = new double[n];
        p[start] = 1d;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (double[] a : graph.getOrDefault(cur, Collections.emptyList())) {
                int next = (int) a[0];
                double prob = a[1];
                if (p[cur]*prob > p[next]) {
                    p[next] = p[cur]*prob;
                    queue.offer(next);
                }
            }
        }
        return p[end];
    }

    // Dijkstra
    public double maxProbability3(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for (int i=0; i<edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }

        double[] p = new double[n];
        p[start] = 1d;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> -p[o]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == end) return p[end];

            for (double[] a : graph.getOrDefault(cur, Collections.emptyList())) {
                int next = (int) a[0];
                double prob = a[1];
                if (p[cur]*prob > p[next]) {
                    p[next] = p[cur]*prob;
                    pq.offer(next);
                }
            }
        }

        return 0d;
    }

}
