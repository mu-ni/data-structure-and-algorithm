package algorithm.TreeAndGraph;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> pair : tickets) {
            String depa = pair.get(0);
            String dest = pair.get(1);

            List<String> list = map.getOrDefault(depa, new ArrayList<>());
            list.add(dest);
            map.put(depa, list);
        }

        List<String> rst = new ArrayList<>();
        dfs("JFK", rst, map);
        return rst;
    }

    public void dfs(String depa, List<String> rst, Map<String, List<String>> map) {
        List<String> dest = map.get(depa);
        while (dest != null && !dest.isEmpty()) {
            Collections.sort(dest); // not necessary
            String next_depa = dest.remove(0);
            dfs(next_depa, rst, map);
        }
        rst.add(0, depa);
    }
}
