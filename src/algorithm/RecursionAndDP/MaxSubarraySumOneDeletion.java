package algorithm.RecursionAndDP;

/**
 * Created by muni on 2019/12/11
 */
public class MaxSubarraySumOneDeletion {
    public static void main(String[] args) {
        System.out.println(new MaxSubarraySumOneDeletion().maximumSum(new int[]{2,1,-2,-5,-2}));
    }

    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int rst = arr[0];
        int[] maxEndHere = new int[n];
        maxEndHere[0] = arr[0];
        for (int i=1; i<n; i++) {
            maxEndHere[i] = Math.max(arr[i], maxEndHere[i-1] + arr[i]);
            rst = Math.max(rst, maxEndHere[i]);
        }

        int[] maxStartHere = new int[n];
        maxStartHere[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            maxStartHere[i] = Math.max(arr[i], maxStartHere[i+1] + arr[i]);
            // not necessary
//            rst = Math.max(rst, maxStartHere[i]);
        }

        for (int i=1; i<n-1; i++) {
            rst = Math.max(rst, maxStartHere[i+1] + maxEndHere[i-1]);
        }
        return rst;
    }
}
