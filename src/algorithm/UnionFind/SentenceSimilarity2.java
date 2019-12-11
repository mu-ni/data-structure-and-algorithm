package algorithm.UnionFind;


import java.util.*;

/**
 * Created by muni on 2019/12/11
 */
public class SentenceSimilarity2 {
    public static void main(String[] args) {
        List<List<String>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList("great", "good"));
        pairs.add(Arrays.asList("fine", "good"));
        pairs.add(Arrays.asList("acting","drama"));
        pairs.add(Arrays.asList("skills","talent"));
        System.out.println(new SentenceSimilarity2().areSentencesSimilar(new String[]{"great", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, pairs));
        System.out.println(new SentenceSimilarity2().areSentencesSimilar2(new String[]{"great", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, pairs));
    }

    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Map<String, String> map = new HashMap<>();
        union(map, pairs);
        for (int i=0; i<words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];

            if (w1.equals(w2)) continue;

            String p1 = find(map, w1);
            String p2 = find(map, w2);

            if (!p1.equals(p2)) return false;
        }
        return true;
    }

    public void union(Map<String, String> map, List<List<String>> pairs) {
        for (List<String> pair : pairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);

            map.putIfAbsent(w1, w1);
            map.putIfAbsent(w2, w2);

            String p1 = find(map, w1);
            String p2 = find(map, w2);
            map.put(p1, p2);
        }
    }

    public String find(Map<String, String> map, String w) {
        if (!map.containsKey(w)) return w;

        while (!w.equals(map.get(w))) {
            w = map.get(w);
        }
        return w;
    }

    public boolean areSentencesSimilar2(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> graph = new HashMap<>();
        buildGraph(graph, pairs);
        for (int i=0; i<words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];

            if (w1.equals(w2)) continue;
            boolean found = dfs(graph, w1, w2, new HashSet<>());
            if (!found) return false;
        }

        return true;
    }

    public void buildGraph(Map<String, Set<String>> graph, List<List<String>> pairs) {
        for (List<String> pair : pairs) {
            String w1 = pair.get(0);
            String w2 = pair.get(1);

            graph.putIfAbsent(w1, new HashSet<>());
            graph.putIfAbsent(w2, new HashSet<>());

            graph.get(w1).add(w2);
            graph.get(w2).add(w1);
        }
    }

    public boolean dfs(Map<String, Set<String>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start) || visited.contains(start)) return false;
        if (graph.get(start).contains(end)) return true;

        visited.add(start);
        for (String next : graph.get(start)) {
            if (visited.contains(next)) continue;
            boolean found = dfs(graph, next, end, visited);
            if (found) return true;
        }
        return false;
    }
}