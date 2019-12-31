package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by muni on 2019/12/31
 */
public class LRUCache2 {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int  key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int cap;
    public LRUCache2(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.cap = capacity;
    }

    private void insertHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteNode(map.get(key));
            map.remove(key);
        }

        if (map.size() == cap) {
            Node rem = tail.prev;
            deleteNode(rem);
            map.remove(rem.key);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insertHead(node);
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2( 2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        cache = new LRUCache2( 2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}
