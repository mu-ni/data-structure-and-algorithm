package algorithm.SetAndMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by muni on 2020/1/17
 */
public class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }

    // not really understand
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = buildMap(nums);
        int pre = 0;
        int cur = 0;
        for (int key : map.keySet()) {
            if (!map.containsKey(key - 1)) {
                pre = cur;
                cur += key * map.get(key);
            } else {
                int tmp = Math.max(cur, pre + key * map.get(key));
                pre = cur;
                cur = tmp;
            }
        }
        return cur;
    }

    private Map<Integer, Integer> buildMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }
        return map;
    }
}
