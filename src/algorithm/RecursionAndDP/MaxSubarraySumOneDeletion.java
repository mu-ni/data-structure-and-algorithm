package algorithm.RecursionAndDP;

/**
 * Created by muni on 2019/12/11
 */
public class MaxSubarraySumOneDeletion {
    public static void main(String[] args) {
        System.out.println(new MaxSubarraySumOneDeletion().maximumSum(new int[]{1,-4,-5,-2,5,0,-1,2}));
    }

    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return -1;
        int rst = arr[0];

        int[] left = new int[n];
        left[0] = arr[0];
        for (int i=1; i<n; i++) {
            left[i] = Math.max(arr[i], arr[i] + left[i-1]);
            rst = Math.max(rst, left[i]);
        }
        int[] right = new int[n];
        right[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            right[i] = Math.max(arr[i], arr[i] + right[i+1]);
            // not necessary
            rst = Math.max(rst, right[i]);
        }

        for (int i=1; i<n-1; i++) {
            rst = Math.max(rst, left[i-1] + right[i+1]);
        }
        return rst;
    }
}
