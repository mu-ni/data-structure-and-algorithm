package design;

import java.util.*;

// Least Frequently Used (LFU)
public class LFUCache {
    int capacity;
    Map<Integer, Integer> keyValueMap;
    Map<Integer, Integer> keyCountMap;
    TreeMap<Integer, List<Integer>> countValueMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyCountMap = new HashMap<>();
        countValueMap = new TreeMap<>();
    }

    public int get(int key) {
        if (!keyValueMap.containsKey(key)) return -1;
        int count = keyCountMap.get(key)+1;
        keyCountMap.put(key, count);
        List<Integer> list = countValueMap.get(count-1);
        list.remove(Integer.valueOf(key));
        if (list.size() == 0) {
            countValueMap.remove(count-1);
        }
        countValueMap.putIfAbsent(count, new ArrayList<>());
        countValueMap.get(count).add(key);
        return keyValueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            get(key);
            return;
        }

        if (keyValueMap.size() >= capacity) {
            Integer minCount = countValueMap.firstKey();
            List<Integer> list = countValueMap.get(minCount);
            Integer remVal = list.get(0);
            keyValueMap.remove(remVal);
            keyCountMap.remove(remVal);
            list.remove(remVal);
            if (list.size() == 0) {
                countValueMap.remove(minCount);
            }
        }
        keyValueMap.put(key, value);
        int count = keyCountMap.getOrDefault(key, 0) + 1;
        keyCountMap.put(key, count);
        countValueMap.putIfAbsent(count, new ArrayList<>());
        countValueMap.get(count).add(key);
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);                        // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        System.out.println();
        cache = new LFUCache(3);
        cache.put(2, 2);
        cache.put(1, 1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
