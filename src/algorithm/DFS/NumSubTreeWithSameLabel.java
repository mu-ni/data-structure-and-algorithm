package algorithm.DFS;

import java.util.*;

/**
 * Created by muni on 2020/7/21
 */
public class NumSubTreeWithSameLabel {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1}, {0,2}, {1,4}, {1,5}, {2,3}, {2,6}};
        System.out.println(Arrays.toString(new NumSubTreeWithSameLabel().countSubTrees(7, edges, "abaedcd")));
        edges = new int[][]{{0,1},{1,2},{2,3},{3,4},{4,5},{5,6}};
        System.out.println(Arrays.toString(new NumSubTreeWithSameLabel().countSubTrees(7, edges, "aaabaaa")));
        edges = new int[][]{{0,2},{0,3},{1,2}};
        System.out.println(Arrays.toString(new NumSubTreeWithSameLabel().countSubTrees(4, edges, "aeed")));
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[1]).add(e[0]);
        }
        int[] rst = new int[n];
        dfs(0, map, labels, rst, new HashSet<>());
        return rst;
    }

    private int[] dfs(int n, Map<Integer, List<Integer>> map, String labels, int[] rst, Set<Integer> visited) {
        int[] arr = new int[26];
        if (visited.contains(n)) return arr;
        visited.add(n);
        for (int child : map.getOrDefault(n, Collections.emptyList())) {
            int[] sub = dfs(child, map, labels, rst, visited);
            for (int i=0; i<26; i++) {
                arr[i] += sub[i];
            }
        }
        char c = labels.charAt(n);
        arr[c - 'a']++;
        rst[n] += arr[c - 'a'];
        return arr;
    }

//    private int dfs(int n, Map<Integer, List<Integer>> map, String labels, char c, Set<Integer> visited) {
//        if (!map.containsKey(n)) return labels.charAt(n) == c ? 1 : 0;
//        int count = labels.charAt(n) == c ? 1 : 0;
//        for (int next : map.getOrDefault(n, new ArrayList<>())) {
//            count += dfs(next, map, labels, c, visited);
//        }
//        return count;
//    }

    // even though node.label != c, CONTINUE to calculate its leaves
//    private int dfs(int n, Map<Integer, List<Integer>> map, String labels, char c) {
//        if (labels.charAt(n) != c) return 0;
//        int count = 1;
//        for (int next : map.getOrDefault(n, new ArrayList<>())) {
//            count += dfs(next, map, labels, c);
//        }
//        return count;
//    }
}
