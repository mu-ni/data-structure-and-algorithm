package algorithm.SetAndMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by muni on 2020/7/7
 */
public class AvoidFloodInTheCity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AvoidFloodInTheCity().avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
    }

    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] rst = new int[rains.length];
        for (int i=0; i<rains.length; i++) {
            if (rains[i] == 0) {
                set.add(i);
                rst[i] = 1;
                continue;
            }
            if (map.containsKey(rains[i])) {
                int n = map.get(rains[i]);
                Integer next = set.higher(n); // > n
                if (next == null) return new int[0];
                rst[next] = rains[i];
                set.remove(next);
            }
            rst[i] = -1;
            map.put(rains[i], i);
        }
        return rst;
    }
}
