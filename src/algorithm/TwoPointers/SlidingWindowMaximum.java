package algorithm.TwoPointers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] rst = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(rst));
        rst = new SlidingWindowMaximum().maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(rst));
        rst = new SlidingWindowMaximum().maxSlidingWindow3(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(rst));
    }

    // brute force
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return nums;
        int[] rst = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            rst[index++] = max;
        }
        return rst;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 0) return nums;
        // deque keeps decreasing values's index
        Deque<Integer> deque = new LinkedList<>();
        int[] rst = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // remove smaller numbers in k range
            deque.offer(i);
            if (i - k + 1 >= 0) {
                rst[index++] = nums[deque.peek()];
            }
        }
        return rst;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (k == 0) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] rst = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
            if (i - k + 1 >= 0) {
                rst[index++] = nums[deque.peekFirst()];
            }
        }
        return rst;
    }
}
