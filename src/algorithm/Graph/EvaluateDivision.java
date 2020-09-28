package algorithm.Graph;

import java.util.*;

/**
 * Created by muni on 2020/9/28
 */
public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, values, queries)));
        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation2(equations, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i=0; i<equations.size(); i++) {
            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1/values[i]);
        }

        double[] rst = new double[queries.size()];
        for (int i=0; i<queries.size(); i++) {
            rst[i] = dfs(map, queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>());
        }
        return rst;
    }

    private double dfs(Map<String, Map<String, Double>> map, String s1, String s2, double v, Set<String> visited) {
        if (!map.containsKey(s1) || visited.contains(s1)) return -1;
        if (s1.equals(s2)) return v;
        visited.add(s1);
        Map<String, Double> next = map.get(s1);
        for (String key : next.keySet()) {
            double rst = dfs(map, key, s2, v*next.get(key), visited);
            if (rst != -1) return rst;
        }
        return -1;
    }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> parent = new HashMap<>(); // node, parent
        Map<String, Double> ratio = new HashMap<>(); // node, node/parent
        for (int i=0; i<equations.size(); i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            union(parent, ratio, s1, s2, values[i]);
        }
        double[] rst = new double[queries.size()];
        for (int i=0; i<queries.size(); i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);
            if (parent.containsKey(s1) && parent.containsKey(s2) && find(parent, ratio, s1).equals(find(parent, ratio, s2))) {
                rst[i] = ratio.get(s1)/ratio.get(s2);
            } else {
                rst[i] = -1;
            }
        }
        return rst;
    }

    private void union(Map<String, String> parent, Map<String, Double> ratio, String s1, String s2, double v) {
        parent.putIfAbsent(s1, s1);
        parent.putIfAbsent(s2, s2);
        ratio.putIfAbsent(s1, 1d);
        ratio.putIfAbsent(s2, 1d);
        String p1 = find(parent, ratio, s1);
        String p2 = find(parent, ratio, s2);
        parent.put(p1, p2);
        ratio.put(p1, v*(ratio.get(s2)/ratio.get(s1)));
    }

    private String find(Map<String, String> parent, Map<String, Double> ratio, String s) {
        if (s.equals(parent.get(s))) return s;
        String father = parent.get(s);
        String grandpa = find(parent, ratio, father);
        parent.put(s, grandpa);
        ratio.put(s, ratio.get(s) * ratio.get(father));
        return grandpa;
    }
}
