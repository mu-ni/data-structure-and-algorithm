package algorithm.Graph;

import java.util.*;

/**
 * Created by muni on 2020/11/4
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) adjList.add(new HashSet<>());
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        List<Integer> rst = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (adjList.get(i).size() == 1) rst.add(i);
        }

        while (n > 2) {
            n -= rst.size();
            List<Integer> list = new ArrayList<>();
            for (int i : rst) {
                int next = adjList.get(i).iterator().next(); // only put adjList.get(i).size() == 1 to rst
                adjList.get(next).remove(i);
                if (adjList.get(next).size() == 1) list.add(next);
            }
            rst = list;
        }
        return rst;
    }
}
