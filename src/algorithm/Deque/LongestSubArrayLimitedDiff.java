package algorithm.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by muni on 2020/5/20
 */
public class LongestSubArrayLimitedDiff {
    public static void main(String[] args) {
        System.out.println(new LongestSubArrayLimitedDiff().longestSubarray(new int[]{8,2,4,7}, 4));
    }

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxd = new LinkedList<>();
        Deque<Integer> mind = new LinkedList<>();
        int start = 0;
        int rst = 0;
        for (int i=0; i<nums.length; i++) {
            while (!maxd.isEmpty() && nums[i] > maxd.peekLast()) {
                maxd.pollLast();
            }
            maxd.offer(nums[i]);
            while (!mind.isEmpty() && nums[i] < mind.peekLast()) {
                mind.pollLast();
            }
            mind.offer(nums[i]);
            while (maxd.peekFirst() - mind.peekFirst() > limit) {
                if (maxd.peekFirst() == nums[start]) maxd.pollFirst();
                if (mind.peekFirst() == nums[start]) mind.pollFirst();
                start++;
            }
            rst = Math.max(rst, i - start + 1);
        }
        return rst;
    }
}
