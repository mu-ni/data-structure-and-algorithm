package algorithm.UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muni on 2020/1/14
 */
public class GraphValidTree {
    public static void main(String[] args) {
        System.out.println(new GraphValidTree().validTree(5, new int[][]{{0,1},{0,4},{1,4},{2,3}}));
        System.out.println(new GraphValidTree().validTree2(5, new int[][]{{0,1},{0,4},{1,4},{2,3}}));
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            boolean hasCycle = uf.union(edge[0], edge[1]);
            if (hasCycle) return false;
        }
        return uf.count() == 1;
    }

    class UnionFind {
        int[] parent;
        int count;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int p, int q) {
            int p1 = find(p);
            int p2 = find(q);
            if (p1 == p2) return true;
            int min = Math.min(p, q);
            int max = Math.max(p, q);
            parent[max] = min;
            count--;
            return false;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public int count() {
            return count;
        }
    }

    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        boolean hasCycle = dfs(graph, 0, visited, -1);
        if (hasCycle) return false;
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int cur, boolean[] visited, int parent) {
        visited[cur] = true;
        for (int next : graph.get(cur)) {
            if (visited[next] && parent != next || !visited[next] && dfs(graph, next, visited, cur)) return true;
        }
        return false;
    }
}
