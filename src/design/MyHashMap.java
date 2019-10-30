package design;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Node>[] lists;

    /** Initialize your data structure here. */
    public MyHashMap() {
        lists = new List[10];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%10;
        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }
        for (Node node : lists[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        lists[index].add(new Node(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%10;
        if (lists[index] == null) return -1;
        for (Node node : lists[index]) {
            if (node.key == key) return node.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%10;
        if (lists[index] == null) return;
        for (Node node : lists[index]) {
            if (node.key == key) {
                lists[index].remove(node);
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2,1);
        System.out.println(map.get(2));
        System.out.println(map.get(2));
        System.out.println(map.get(2));
    }
}
