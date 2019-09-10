package algorithm.LinkedList.Dao;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    public String toString() {
        StringBuilder sb =  new StringBuilder();
        Node cur = this;
        while(cur != null) {
            sb.append("node: ").append(cur.val).append(", ");
            sb.append("next: ").append(cur.next == null ? "null" : cur.next.val).append(", ");
            sb.append("random: ").append(cur.random == null ? "null" : cur.random.val).append("\n");
            cur = cur.next;
        }
        return sb.toString();
    }
}
