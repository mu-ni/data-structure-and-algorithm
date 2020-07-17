package algorithm.SearchAndSort;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(new TopKFrequent().topKFrequent(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(new TopKFrequent().topKFrequent2(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(new TopKFrequent().topKFrequent3(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent4(new int[]{1, 1, 1, 2, 2, 3}, 2)));
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

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>[] times = new List[nums.length];
        for (int key : map.keySet()) {
            if (times[map.get(key)-1] == null) {
                times[map.get(key)-1] = new ArrayList<>();
            }
            times[map.get(key)-1].add(key);
        }

        List<Integer> rst = new ArrayList<>();
        int index = 0;
        boolean found = false;
        for (int i=nums.length-1; i>=0; i--) {
            if (found) break;
            if (times[i] == null) continue;
            for (int n : times[i]) {
                rst.add(n);
                index++;
                if (index == k) {
                    found = true;
                    break;
                }
            }
        }
        return rst;
    }

    public List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0)+1;
            map.put(n, count);
        }

        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<=nums.length; i++) {
            lists.add(new ArrayList<>());
        }
        for (int key : map.keySet()) {
            int count = map.get(key);
            lists.get(count).add(key);
        }

        List<Integer> rst = new ArrayList<>();
        for (int i=nums.length; i>0; i--) {
            if(lists.get(i).size() == 0) continue;
            for (int n : lists.get(i)) {
                rst.add(n);
                if (rst.size() == k) return rst;
            }
        }
        return new ArrayList<>();
    }

    public int[] topKFrequent4(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0)+1;
            map.put(n, count);
        }

        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0; i<=nums.length; i++) {
            lists.add(new ArrayList<>());
        }
        for (int key : map.keySet()) {
            int count = map.get(key);
            lists.get(count).add(key);
        }

        List<Integer> rst = new ArrayList<>();
        for (int i=nums.length; i>0; i--) {
            if(lists.get(i).size() == 0) continue;
            for (int n : lists.get(i)) {
                rst.add(n);
                if (rst.size() == k) return rst.stream().mapToInt(o -> o).toArray();
            }
        }
        return new int[0];
    }
}
