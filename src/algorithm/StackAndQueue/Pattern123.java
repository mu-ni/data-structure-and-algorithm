package algorithm.StackAndQueue;

import java.util.Stack;

/**
 * Created by muni on 2020/10/23
 */
public class Pattern123 {
    public static void main(String[] args) {
        System.out.println(new Pattern123().find132pattern(new int[]{3,1,4,2}));
        System.out.println(new Pattern123().find132pattern2(new int[]{3,1,4,2}));
        System.out.println(new Pattern123().find132pattern3(new int[]{3,1,4,2}));
    }

    // i < j < k and nums[i] < nums[k] < nums[j].
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) return true;
                }
            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                continue;
            }
            for (int j=i+1; j<n; j++) {
                if (min < nums[j] && nums[j] < nums[i]) return true;
            }
        }
        return false;
    }

    // 单调递增栈
    public boolean find132pattern3(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i=nums.length-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                max = stack.pop();
            }
            if (nums[i] > max) stack.push(nums[i]);
            if (nums[i] < max) return true;
        }
        return false;
    }
}
