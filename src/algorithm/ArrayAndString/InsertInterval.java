package algorithm.ArrayAndString;

import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{6,9}};
        System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals, new int[]{2,5})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] rst = Arrays.copyOf(intervals,  intervals.length+1);
        rst[intervals.length] = newInterval;
        return new MergeIntervals().merge(rst);
    }
}
