package algorithm.TwoPointers;

import java.util.Arrays;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    // TLE
    // TODO
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] rst = new double[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            rst[index++] = getMedian(nums, i, i + k);
        }
        return rst;
    }

    public double getMedian(int[] nums, int start, int end) {
        int[] sorted = Arrays.copyOfRange(nums, start, end);
        Arrays.sort(sorted);
        int len = sorted.length;
        if (len % 2 == 1) return sorted[len / 2];
        return  sorted[len / 2 - 1] + (double)(sorted[len / 2] - sorted[len / 2 - 1]) / 2;
    }
}
