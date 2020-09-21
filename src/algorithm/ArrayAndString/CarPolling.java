package algorithm.ArrayAndString;

import java.util.*;

/**
 * Created by muni on 2020/9/21
 */
public class CarPolling {
    public static void main(String[] args) {
        System.out.println(new CarPolling().carPooling(new int[][]{{2,1,5},{3,3,7}}, 4));
        System.out.println(new CarPolling().carPooling2(new int[][]{{2,1,5},{3,3,7}}, 4));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>(); // sort by key
        for (int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        for (int n : map.values()) {
            capacity -= n;
            if (capacity < 0) return false;
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
            set.add(trip[1]);
            set.add(trip[2]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i : list) {
            capacity -= map.get(i);
            if (capacity < 0) return false;
        }
        return true;
    }
}
