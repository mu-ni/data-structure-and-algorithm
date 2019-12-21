package algorithm.Graph;

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
        System.out.println(new ReconstructItinerary().findItinerary2(tickets));
        System.out.println(new ReconstructItinerary().findAllItineraries(tickets));
        System.out.println(new ReconstructItinerary().findItinerary4(tickets));
        System.out.println(new ReconstructItinerary().findItinerary5(tickets));
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
            Collections.sort(dest); // keep smallest lexical order
            String next_depa = dest.remove(0);
            dfs(next_depa, rst, map);
        }
        rst.add(0, depa);
    }

    public List<String> findItinerary2(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> pair : tickets) {
            String from = pair.get(0);
            String to = pair.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        List<String> rst = new ArrayList<>();
        boolean found = backtrack("JFK", rst, map, tickets.size() +1);
        return found ? rst : new ArrayList<>();
    }

    public boolean backtrack(String from, List<String> rst, Map<String, List<String>> map, int stops) {
        rst.add(from);
        if (rst.size() == stops) return true;
        if (!map.containsKey(from) || map.get(from).size() == 0) return false;

        List<String> dests = map.get(from);
        Collections.sort(dests);
        for (int i=0; i<dests.size(); i++) {
            String to = dests.remove(i);
            boolean found = backtrack(to, rst, map, stops);
            if (found) return true;
            rst.remove(rst.size()-1);
            dests.add(i, to);
        }
        return false;
    }

    public List<List<String>> findAllItineraries(List<List<String>> tickets) {
        if (tickets.size() == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> pair : tickets) {
            String key = pair.get(0);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(pair.get(1));
        }

        List<List<String>> rst = new ArrayList<>();
        int stops = tickets.size()+1;
        List<String> path = new ArrayList<>();
        path.add("JFK");
        backtrack(rst, map, stops, path);
        return rst;
    }

    public void backtrack(List<List<String>> rst, Map<String, List<String>> map, int stops, List<String> path) {
        if (path.size() == stops) {
            rst.add(new ArrayList<>(path));
            return;
        }

        String from = path.get(path.size()-1);
        List<String> dests = map.get(from);
        for (int i=0; i<dests.size(); i++) {
            String dest = dests.remove(i);
            path.add(dest);
            backtrack(rst, map, stops, path);
            path.remove(path.size()-1);
            dests.add(i, dest);
        }
    }

    public List<String> findItinerary4(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            String from = pair.get(0);
            String to = pair.get(1);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }
        List<String> rst = new ArrayList<>();
        boolean found = backtrack(rst, graph, "JFK", tickets.size()+1);
        return found ? rst : new ArrayList<>();
    }

    public boolean backtrack(List<String> rst, Map<String, List<String>> graph, String from, int stops) {
        rst.add(from);
        if (rst.size() == stops) return true;
        if (!graph.containsKey(from) || graph.get(from).size() == 0) return false;
        List<String> destList = graph.get(from);
        Collections.sort(destList);
        for (int i=0; i<destList.size(); i++) {
            String to = destList.remove(i);
            boolean found = backtrack(rst, graph, to, stops);
            if (found) return true;
            destList.add(i, to);
            rst.remove(rst.size()-1);
        }
        return false;
    }

    public List<String> findItinerary5(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            String from = pair.get(0);
            String to = pair.get(1);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }
        List<String> rst = new ArrayList<>();
        rst.add("JFK");
        boolean found = backtrack(rst, graph, tickets.size()+1);
        return found ? rst : new ArrayList<>();
    }

    public boolean backtrack(List<String> rst, Map<String, List<String>> graph, int stops) {
        String from = rst.get(rst.size()-1);
        if (rst.size() == stops) return true;
        if (!graph.containsKey(from) || graph.get(from).size() == 0) return false;
        List<String> destList = graph.get(from);
        Collections.sort(destList);
        for (int i=0; i<destList.size(); i++) {
            String to = destList.remove(i);
            rst.add(to);
            boolean found = backtrack(rst, graph, stops);
            if (found) return true;
            destList.add(i, to);
            rst.remove(rst.size()-1);
        }
        return false;
    }
}
