package algorithm.Backtrack;

import java.util.*;

/**
 * Created by muni on 2020/7/24
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i=0; i<graph.length; i++) {
            map.put(i, graph[i]);
        }
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> path = new ArrayList<>(Collections.singletonList(0));
        backtrack(rst, map, path);
        return rst;
    }

    private void backtrack(List<List<Integer>> rst, Map<Integer, int[]> map, List<Integer> path) {
        int cur = path.get(path.size()-1);
        if (cur == map.size()-1) {
            rst.add(new ArrayList<>(path));
            return;
        }
        for (int next : map.getOrDefault(cur, new int[0])) {
            path.add(next);
            backtrack(rst, map, path);
            path.remove(path.size()-1);
        }
    }
}
