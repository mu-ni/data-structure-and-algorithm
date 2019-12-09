package algorithm.amz;

import java.util.*;

/**
 * Created by muni on 2019/12/9
 */
public class DataCenterCirticalConnections {
    public static void main(String[] args) {
        Integer[][] arrs = new Integer[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        List<List<Integer>> connections = new ArrayList<>();
        for (Integer[] arr : arrs) {
            connections.add(Arrays.asList(arr));
        }
        System.out.println(new DataCenterCirticalConnections().criticalConnections(4, connections));
        System.out.println(new DataCenterCirticalConnections().criticalConnections2(4, connections));
    }

    // TODO
    // TLE
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashSet<List<Integer>> edges = new HashSet();
        HashMap<Integer, List<Integer>> graph = new HashMap();
        for(List<Integer> connection : connections){
            if(connection.get(0) > connection.get(1)){
                int temp = connection.get(0);
                connection.set(0, connection.get(1));
                connection.set(1, temp);
            }
            edges.add(connection);
            List list = graph.computeIfAbsent(connection.get(0), k -> new ArrayList());
            list.add(connection.get(1));
            list = graph.computeIfAbsent(connection.get(1), k -> new ArrayList());
            list.add(connection.get(0));
        }
        int[] rank = new int[n];
        /*Not use -1, prevent node 0 checking previous node visited*/
        Arrays.fill(rank, -2);
        backtrack(edges, graph, rank, 0, 0);
        return new ArrayList(edges);
    }

    public int backtrack(HashSet<List<Integer>> edges, HashMap<Integer, List<Integer>> graph, int[] rank, int node, int height){
        if(rank[node] >= 0) return rank[node];
        rank[node] = height;
        int min_height = height;
        for(Integer neighbor : graph.get(node)){
            /*Check previous node visited*/
            if(rank[neighbor] == height - 1) continue;
            int feedback = backtrack(edges, graph, rank, neighbor, height + 1);
            min_height = Math.min(min_height, feedback);
            if(feedback <= height){
                edges.remove(Arrays.asList(Math.min(neighbor, node), Math.max(neighbor, node)));
            }
        }
        return min_height;
    }

    public List<List<Integer>> criticalConnections2(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
        // use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // build graph
        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, res, i);
            }
        }
        return res;
    }

    int time = 0; // time when discover each vertex

    private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
        disc[u] = low[u] = ++time; // discover u
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);
            if (v == pre) {
                continue; // if parent vertex, ignore
            }
            if (disc[v] == -1) { // if not discovered
                dfs(v, low, disc, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    res.add(Arrays.asList(u, v));
                }
            } else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
