package algorithm.SearchAndSort;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(new TopKFrequent().topKFrequent(new int[]{1}, 1));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        List[] freqList = new List[nums.length+1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freqList[freq] == null) {
                freqList[freq] = new ArrayList();
            }
            freqList[freq].add(key);
        }

        List<Integer> rst = new ArrayList<>();
        for (int i=freqList.length-1; i>=0; i--) {
            if (freqList[i] == null) continue;
            rst.addAll(freqList[i]);
            k -= freqList[i].size();
            if (k <= 0) break;
        }

        return rst;
    }
}
