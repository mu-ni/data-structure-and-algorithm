package algorithm.UnionFind;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        Integer[][] arr = new Integer[][]{{0,3},{1,2}};
        List<List<Integer>> pairs = Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("dcab", pairs));
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps2("dcab", pairs));
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps3("dcab", pairs));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, pairs);

        boolean[] visited = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            if (visited[i]) continue;
            queue.offer(i);
            List<Character> lc = new ArrayList<>();
            List<Integer> li = new ArrayList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (visited[cur]) continue;
                visited[cur] = true;
                lc.add(s.charAt(cur));
                li.add(cur);
                for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                    queue.offer(next);
                }
            }
            buildArr(arr, lc, li);
        }

        return new String(arr);
    }

    private void buildArr(char[] arr, List<Character> lc, List<Integer> li) {
        Collections.sort(lc);
        Collections.sort(li);
        for (int j=0; j<lc.size(); j++) {
            arr[li.get(j)] = lc.get(j);
        }
    }

    public String smallestStringWithSwaps2(String s, List<List<Integer>> pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, pairs);

        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[s.length()];
        for (int i=0; i<s.length(); i++) {
            if (visited[i]) continue;
            List<Integer> list = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (visited[cur]) continue;
                visited[cur] = true;
                list.add(cur);
                for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                    queue.offer(next);
                }
            }
            buildArr(arr, s, list);
        }
        return new String(arr);
    }

    private void buildArr(char[] arr, String s, List<Integer> list) {
        char[] sorted = new char[list.size()];
        for (int i=0; i<list.size(); i++) {
            sorted[i] = s.charAt(list.get(i));
        }
        Arrays.sort(sorted);
        Collections.sort(list);
        for (int i=0; i<list.size(); i++) {
            arr[list.get(i)] = sorted[i];
        }
    }

    private void buildGraph(Map<Integer, List<Integer>> graph, List<List<Integer>> pairs) {
        for (List<Integer> pair : pairs) {
            List<Integer> list = graph.getOrDefault(pair.get(0), new ArrayList<>());
            list.add(pair.get(1));
            graph.put(pair.get(0), list);

            list = graph.getOrDefault(pair.get(1), new ArrayList<>());
            list.add(pair.get(0));
            graph.put(pair.get(1), list);
        }
    }

    public String smallestStringWithSwaps3(String s, List<List<Integer>> pairs) {
        int[] p = new int[s.length()];
        for (int i = 0; i < p.length; i++) p[i] = i;
        for (List<Integer> pair : pairs) {
            union(p, pair.get(0), pair.get(1));
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            int parent = find(p, i);
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(i);
        }
        char[] arr = s.toCharArray();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> group = entry.getValue();
            List<Character> temp = new ArrayList<>();
            for (int ind : group) temp.add(arr[ind]);
            Collections.sort(temp);
            for (int i = 0; i < group.size(); i++) {
                arr[group.get(i)] = temp.get(i);
            }
        }
        return new String(arr);
    }

    public void union (int[] p, int nodeA, int nodeB) {
        int A = find(p, nodeA);
        int B = find(p, nodeB);
        if (A != B) p[A] = B;
    }

    public int find(int[] p, int node) {
        if (p[node] == node) return node;
        return p[node] = find(p, p[node]);
    }
}
