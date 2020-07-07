package algorithm.StackAndQueue;

import java.util.*;

/**
 * Created by muni on 2020/7/7
 */
public class FindLeastNumOfUniqueInts {
    public static void main(String[] args) {
        System.out.println(new FindLeastNumOfUniqueInts().findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }
        // sort by map value
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        pq.addAll(map.keySet());
        while (k > 0) {
            k -= map.get(pq.poll());
        }
        return k == 0 ? pq.size() : pq.size() + 1;
    }
}
