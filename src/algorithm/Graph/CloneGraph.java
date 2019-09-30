package algorithm.Graph;

import algorithm.TreeAndGraph.Dao.Node;

import java.util.*;

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

        System.out.println(new CloneGraph().cloneGraph(n1));
        System.out.println(new CloneGraph().cloneGraph2(n1));
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node.val, new Node(node.val, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node nbr : cur.neighbors) {
                if (!map.containsKey(nbr.val)) {
                    map.put(nbr.val, new Node(nbr.val, new ArrayList<>()));
                    queue.offer(nbr);
                }
                map.get(cur.val).neighbors.add(map.get(nbr.val));
            }
        }

        return map.get(node.val);
    }

    public Node cloneGraph2(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, new Node(node.val, new ArrayList<>()));
        dfs(node, map);
        return map.get(node.val);
    }

    public void dfs(Node node, Map<Integer, Node> map) {
        for (Node nbr : node.neighbors) {
            if (!map.containsKey(nbr.val)) {
                map.put(nbr.val, new Node(nbr.val, new ArrayList<>()));
                dfs(nbr, map);
            }
            map.get(node.val).neighbors.add(map.get(nbr.val));
        }
    }
}
