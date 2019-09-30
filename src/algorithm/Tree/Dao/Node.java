package algorithm.Tree.Dao;

import java.util.*;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public String toString() {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(this);
        set.add(this);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node nbs : node.neighbors) {
                if (set.contains(nbs)) continue;
                set.add(nbs);
                queue.offer(nbs);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node node : set) {
            sb.append("node: ").append(node.val).append(", ");
            sb.append("neighbors: ");
            for (Node nbs : node.neighbors) {
                sb.append(nbs.val).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
