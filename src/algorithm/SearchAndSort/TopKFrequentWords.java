package algorithm.SearchAndSort;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);
        }

        List[] arr = new List[words.length];
        for (String key : map.keySet()) {
            int count = map.get(key) - 1; // index
            if (arr[count] == null) {
                arr[count] = new ArrayList();
            }
            arr[count].add(key);
        }

        List<String> list = new ArrayList<>();
        for (int i=words.length-1; i>=0; i--) {
            if (arr[i] == null) continue;
            Collections.sort(arr[i]);
            if (list.size() + arr[i].size() <= k) {
                list.addAll(arr[i]);
                continue;
            }
            int rem = k - list.size();
            list.addAll(arr[i].subList(0, rem));
        }
        return list;
    }
}
