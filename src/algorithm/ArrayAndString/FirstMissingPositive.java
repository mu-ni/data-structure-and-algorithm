package algorithm.ArrayAndString;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(new FirstMissingPositive().firstMissingPositive2(new int[]{3,4,-1,1}));
    }

    // O(nlogn)
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int i=0;
        while (i < nums.length) {
            int index = nums[i];
            if (index >= 0 && index < nums.length && nums[index] != nums[i]) {
                swap(nums, i, index);
            } else {
                i++;
            }
        }

        int rst = 1;
        while (rst < nums.length && nums[rst] == rst) {
            rst++;
        }
        return rst >= nums.length && nums[0] == rst ? rst + 1 : rst;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    // O(n)
    public int firstMissingPositive2(int[] nums) {
        Arrays.sort(nums);
        int rst = 1;
        for (int n : nums) {
            if (n < rst) continue;
            if (n == rst) {
                rst++;
            } else {
                return rst;
            }
        }
        return rst;
    }
}
