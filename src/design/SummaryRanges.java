package design;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by muni on 2019/12/10
 */
public class SummaryRanges {
    TreeMap<Integer, int[]> treeMap;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }

    // key -> start of interval
    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer lower = treeMap.lowerKey(val);
        Integer higher = treeMap.higherKey(val);
        if (lower!= null && higher != null && treeMap.get(lower)[1]+1 == val && higher-1 == val) {
            treeMap.get(lower)[1] = treeMap.get(higher)[1];
            treeMap.remove(higher);
        } else if (lower!= null && treeMap.get(lower)[1]+1 >= val) {
            treeMap.get(lower)[1] = Math.max(treeMap.get(lower)[1], val);
        } else if (higher != null && higher-1 == val) {
            treeMap.put(val, new int[]{val, treeMap.get(higher)[1]});
            treeMap.remove(higher);
        } else {
            treeMap.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        return treeMap.values().toArray(new int[treeMap.values().size()][2]);
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        sr.addNum(1);
        System.out.println(Arrays.deepToString(sr.getIntervals()));
        sr.addNum(3);
        System.out.println(Arrays.deepToString(sr.getIntervals()));
        sr.addNum(7);
        System.out.println(Arrays.deepToString(sr.getIntervals()));
        sr.addNum(2);
        System.out.println(Arrays.deepToString(sr.getIntervals()));
        sr.addNum(6);
        System.out.println(Arrays.deepToString(sr.getIntervals()));
    }
}
