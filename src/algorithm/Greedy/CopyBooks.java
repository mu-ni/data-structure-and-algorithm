package algorithm.Greedy;

public class CopyBooks {
    public static void main(String[] args) {
        System.out.println(new CopyBooks().copyBooks(new int[]{3, 2, 4}, 2));
    }

    // k people, copy continuous pages. At least how many people?
    public int copyBooks(int[] pages, int k) {
        if (pages.length == 0) return 0;
        int max = 0;
        int sum = 0;
        for (int p : pages) {
            max = Math.max(max, p);
            sum += p;
        }

        int left = max; // unlimited people
        int right = sum; // 1 people
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isValid(pages, mid, k)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return isValid(pages, left, k) ? left : right;
    }

    public boolean isValid(int[] pages, int limit, int k) {
        int count = 1;
        int sum = 0;
        for (int p : pages) {
            if (p > limit) return false;
            if (sum + p > limit) {
                count++;
                sum = p;
            } else {
                sum += p;
            }
        }

        return count <= k;
    }

//    works but not understand
//    public int copyBooks2(int[] pages, int k) {
//        if (pages.length == 0) return 0;
//        int n = pages.length;
//        int[] sum = new int[n];
//        for (int i = 0; i < n; i++) {
//            if (i == 0) {
//                sum[i] = pages[i];
//                continue;
//            }
//            sum[i] = sum[i - 1] + pages[i];
//        }
//
//        int[][] dp = new int[n][k];
//        for (int i=0; i<n; i++) {
//            dp[i][0] = sum[i];
//            for (int j=1; j<k; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//                for (int l=i; l>=0; l--) {
//                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[l][j-1], sum[i] - sum[l]));
//                }
//            }
//        }
//
//        return dp[n-1][k-1];
//    }
}
