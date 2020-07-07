package algorithm.StackAndQueue;

import java.util.*;

/**
 * Created by muni on 2020/7/7
 */
public class FindLeastNumOfUniqueInts {
    public static void main(String[] args) {
        System.out.println(new FindLeastNumOfUniqueInts().findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
        System.out.println(new FindLeastNumOfUniqueInts().findLeastNumOfUniqueInts2(new int[]{4,3,1,1,3,3,2}, 3));
        System.out.println(new FindLeastNumOfUniqueInts().findLeastNumOfUniqueInts3(new int[]{4,3,1,1,3,3,2}, 3));
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

    public int findLeastNumOfUniqueInts2(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }
        List[] bucket = new List[arr.length+1];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) bucket[count] = new ArrayList();
            bucket[count].add(key);
        }

        int rst = 0;
        for (int i=0; i<=arr.length; i++) {
            if (bucket[i] == null) continue;
            for (int j=0; j<bucket[i].size(); j++) {
                if (k > 0) {
                    k -= i;
                } else {
                    rst++;
                }
            }
        }
        return k == 0 ? rst : rst + 1;
    }

    public int findLeastNumOfUniqueInts3(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Comparator.comparingInt(map::get));
        while (k > 0) {
            k -= map.get(list.get(0));
            list.remove(0);
        }
        return k == 0 ? list.size() : list.size() + 1;
    }
}
