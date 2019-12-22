package algorithm.Greedy;

import java.util.Arrays;

public class DivideArrayKConsecutiveNumbers {
    public static void main(String[] args) {
        System.out.println(new DivideArrayKConsecutiveNumbers().isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n%k != 0) return false;
        Arrays.sort(nums);

        boolean[] used = new boolean[n];
        int usedCnt = 0;
        int[] arr = new int[k];
        int index = 0;
        for (int i=0; i<n; i++) {
            if (used[i]) continue;
            if (index == 0 || nums[i] == arr[index-1] + 1) {
                arr[index++] = nums[i];
                used[i] = true;
                usedCnt++;
                if (index == k) {
                    i = 0;
                    index = 0;
                    arr = new int[k];
                }
            }
        }
        return usedCnt == n;
    }
}
