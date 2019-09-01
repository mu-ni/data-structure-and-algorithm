package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        for (int i=1; i<intervals.length; i++) {
            if (isOverlap(intervals[i-1], intervals[i])) {
                intervals[i] = getMerge(intervals[i-1], intervals[i]);
                intervals[i-1] = new int[0];
            }
        }
        return Arrays.stream(intervals).filter(arr -> arr.length != 0).toArray(int[][]::new);
    }

    public boolean isOverlap(int[] arr1, int[] arr2) {
        return arr1[1] >= arr2[0];
    }

    public int[] getMerge(int[] arr1, int[] arr2) {
        return new int[]{arr1[0], Math.max(arr1[1], arr2[1])};
    }
}
