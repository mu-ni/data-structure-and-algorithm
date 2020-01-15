package algorithm.RecursionAndDP;

import java.util.Arrays;

/**
 * Created by muni on 2020/1/15
 */
public class MaxLenOfRepeatedSubarray {
    public static void main(String[] args) {
        System.out.println(new MaxLenOfRepeatedSubarray().findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
        System.out.println(new MaxLenOfRepeatedSubarray().findLength2(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    // TLE
    public int findLength(int[] A, int[] B) {
        int len = 0;
        for (int i=0; i<A.length; i++) {
            for (int j=i; j<A.length; j++) {
                int[] sub = Arrays.copyOfRange(A, i, j+1);
                if (isSubstring(sub, B)) {
                    len = Math.max(len, j+1-i);
                }
            }
        }
        return len;
    }

    private boolean isSubstring(int[] arr, int[] B) {
        for (int i=0; i<=B.length - arr.length; i++) {
            int[] arrB = Arrays.copyOfRange(B, i, i+arr.length);
            if (Arrays.equals(arr, arrB)) return true;
        }
        return false;
    }

    public int findLength2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
