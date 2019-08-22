package algorithm.SearchAndSort;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(new TopKFrequent().topKFrequent(new int[]{5,1,1,1,2,2,3,4}, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count+1);
        }

        List[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(n);
        }

        List<Integer> list = new ArrayList<>();
        for (int i=bucket.length-1; i>=0 && k >0; i--) {
            if (bucket[i] == null) continue;
            list.addAll(bucket[i]);
            k -= bucket[i].size();
        }

        return list;
    }
}
