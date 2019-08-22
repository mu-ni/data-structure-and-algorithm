package algorithm.ArrayAndString;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest2(new int[]{3,2,1,5,6,4}, 2));
    }

    // O(nlogn)
    // O(1)
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    // O(n) ~ O(n^2)
    // O(1)
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll(); // poll smallest
            }
        }
        return queue.peek();
    }
}
