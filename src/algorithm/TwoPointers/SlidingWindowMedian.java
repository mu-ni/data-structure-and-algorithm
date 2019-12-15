package algorithm.TwoPointers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    // TLE
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

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public double[] medianSlidingWindow2(int[] nums, int k) {
        double[] rst = new double[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if (i >= k-1) {
                rst[index++] = getMedian();
                remove(nums[i-k+1]);
            }
        }
        return rst;
    }

    private void add(int n) {
        if (n < getMedian()) {
            maxHeap.offer(n);
        } else {
            minHeap.offer(n);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private void remove(int n) {
        if (n < getMedian()) {
            maxHeap.remove(n);
        } else {
            minHeap.remove(n);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private double getMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0) return 0;
        if (minHeap.size() == maxHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek())/2;
        }
        return minHeap.isEmpty() ? (double) maxHeap.peek() : (double) minHeap.peek();
    }
}
