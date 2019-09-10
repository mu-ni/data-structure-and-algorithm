package algorithm.LinkedList;

import algorithm.LinkedList.Dao.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;

        n1.next = n2;
        n1.random = n2;
        n2.next = null;
        n2.random = n2;

        System.out.println(new CopyRandomList().copyRandomList(n1));
    }

    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node();
            node.val = cur.val;
            map.put(cur, node);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
