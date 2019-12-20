package algorithm.RecursionAndDP.OneDimension;

import java.util.Arrays;

public class ProductArrExceptSelf {
    public static void main(String[] args) {
        int[] rst = new ProductArrExceptSelf().productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(rst));
    }

    // without division
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i=1; i<nums.length; i++) {
            left[i] = nums[i-1]*left[i-1];
        }
        int[] right = new int[n];
        right[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            right[i] = nums[i+1]*right[i+1];
        }

        int[] rst = new int[n];
        for (int i=0; i<n; i++) {
            rst[i] = left[i]*right[i];
        }
        return rst;
    }
}
