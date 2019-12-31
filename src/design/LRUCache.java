package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Least Recently Used (LRU) cache
public class LRUCache {
    List<Integer> list;
    Map<Integer, Integer> map;
    int cap;

    public LRUCache(int capacity) {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))  return -1;

        list.remove(Integer.valueOf(key));
        list.add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(Integer.valueOf(key));
            map.remove(key);
        }
        if (list.size() == cap) {
            int rem = list.get(0);
            list.remove(Integer.valueOf(rem));
            map.remove(rem);
        }
        list.add(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        cache = new LRUCache( 2);
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
