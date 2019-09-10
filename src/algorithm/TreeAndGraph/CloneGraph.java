package algorithm.TreeAndGraph;

import algorithm.TreeAndGraph.Dao.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 3;
        Node n4 = new Node();
        n4.val = 4;
        n1.neighbors = Arrays.asList(n2, n4);
        n2.neighbors = Arrays.asList(n1, n3);
        n3.neighbors = Arrays.asList(n2, n4);
        n4.neighbors = Arrays.asList(n1, n3);

        Node newNode = new CloneGraph().cloneGraph(n1);
        System.out.println(newNode);
    }

    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Integer, Node> map = new HashMap<>();
        return helper(node, map);
    }

    public Node helper(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) return map.get(node.val);

        Node n = new Node(node.val, new ArrayList<>());
        map.put(n.val, n);
        for (Node nbs : node.neighbors) {
            n.neighbors.add(helper(nbs, map));
        }
        return n;
    }
}
