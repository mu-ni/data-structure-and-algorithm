package algorithm.SearchAndSort;

public class MaxSideLength {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        System.out.println(new MaxSideLength().maxSideLength(mat, 4));
    }

    int m;
    int n;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        int[][] prefixSum = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                prefixSum[i][j] = mat[i-1][j-1] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        int start = 0;
        int end = Math.min(m, n);
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isValid(prefixSum, mid, threshold)) {
                if (mid == Math.min(m, n) || !isValid(prefixSum, mid+1, threshold)) return mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return 0;
    }

    public boolean isValid(int[][] prefixSum, int len, int threshold) {
        for (int i=len; i<=m; i++) {
            for (int j=len; j<=n; j++) {
                int sum = prefixSum[i][j] - prefixSum[i][j-len] - prefixSum[i-len][j] + prefixSum[i-len][j-len];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
