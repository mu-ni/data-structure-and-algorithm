package algorithm.ArrayAndString;

import java.util.Arrays;

public class ProductArrExceptSelf {
    public static void main(String[] args) {
        int[] rst = new ProductArrExceptSelf().productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(rst));
    }

    // without division
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i=0; i<nums.length-1; i++) {
            left[i+1] = left[i]*nums[i];
        }

        right[nums.length-1] = 1;
        for (int i=nums.length-1; i >0; i--) {
            right[i-1] = right[i]*nums[i];
        }

        int[] rst = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            rst[i] = left[i]*right[i];
        }
        return rst;
    }
}
