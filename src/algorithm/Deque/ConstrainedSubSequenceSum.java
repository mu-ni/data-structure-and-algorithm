package algorithm.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by muni on 2020/5/20
 */
public class ConstrainedSubSequenceSum {
    public static void main(String[] args) {
        System.out.println(new ConstrainedSubSequenceSum().constrainedSubsetSum(new int[]{10,2,-10,-20,5,20}, 2));
        System.out.println(new ConstrainedSubSequenceSum().constrainedSubsetSum(new int[]{-1,-2,-3}, 1));
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Deque<Integer> deque = new LinkedList<>();
        int rst = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (!deque.isEmpty()) {
                nums[i] += deque.peekFirst();
            }
            rst = Math.max(rst, nums[i]);
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            if (nums[i] > 0) {
                deque.offerLast(nums[i]);
            }
            if (i >= k && !deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
        }
        return rst;
    }
}
