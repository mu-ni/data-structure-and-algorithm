package design;

import java.util.*;

/**
 * Created by muni on 2020/9/30
 */
public class ThroneInheritance {
    Map<String, List<String>> map;
    Set<String> set;
    String king;

    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        set = new HashSet<>();
        map.putIfAbsent(kingName, new ArrayList<>());
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        map.putIfAbsent(parentName, new ArrayList<>());
        map.get(parentName).add(childName);
    }

    public void death(String name) {
        set.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(order, king);
        return order;
    }

    private void dfs(List<String> list, String name) {
        if (!set.contains(name)) list.add(name);
        for (String child : map.getOrDefault(name, new ArrayList<>())) {
            dfs(list, child);
        }
    }

    public static void main(String[] args) {
        ThroneInheritance ti = new ThroneInheritance("king");
        ti.birth("king", "andy");
        ti.birth("king", "bob");
        ti.birth("king", "catherine");
        ti.birth("andy", "matthew");
        ti.birth("bob", "alex");
        ti.birth("bob", "asha");
        System.out.println(ti.getInheritanceOrder());
        ti.death("bob");
        System.out.println(ti.getInheritanceOrder());
    }
}
