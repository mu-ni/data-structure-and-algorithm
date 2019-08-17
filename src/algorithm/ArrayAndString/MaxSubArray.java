package algorithm.ArrayAndString;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {// brute force
        int rst = nums[0];
        for (int i=0; i<nums.length; i++) {
            int sum = nums[i];
            int max = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
            rst = Math.max(max, rst);
        }
        return rst;
    }

    public static int maxSubArray2(int[] nums) { // DP
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            arr[i] = Math.max(nums[i] + arr[i-1], nums[i]);
        }
        int max = arr[0];
        for (int n : arr) {
            max = Math.max(n, max);
        }
        return max;
    }

    public static int maxSubArray3(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i=1; i<nums.length; i++) {
            sum = sum < 0 ? nums[i] : sum + nums[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
