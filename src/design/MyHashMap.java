package design;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    class Node {
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    List<List<Node>> lists;
    int k;

    /** Initialize your data structure here. */
    public MyHashMap() {
        lists = new ArrayList<>();
        this.k = 10;
        for (int i=0; i<k; i++) {
            lists.add(new ArrayList<>());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%k;
        for (int i=0; i<lists.get(index).size(); i++) {
            if (lists.get(index).get(i).key == key) {
                lists.get(index).remove(i);
            }
        }
        lists.get(index).add(new Node(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%k;
        List<Node> list = lists.get(index);
        for (Node node : list) {
            if (node.key == key) return node.val;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%k;
        for (int i=0; i<lists.get(index).size(); i++) {
            if (lists.get(index).get(i).key == key) {
                lists.get(index).remove(i);
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
