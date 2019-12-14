package algorithm.Greedy;

public class CopyBooks {
    public static void main(String[] args) {
        System.out.println(new CopyBooks().copyBooks(new int[]{3, 2, 4}, 2));
        System.out.println(new CopyBooks().copyBooks2(new int[]{3, 2, 4}, 2));
    }

    // k people, copy continuous pages. 1 page/min
    // At least how many minutes?
    public int copyBooks(int[] pages, int k) {
        if (pages.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int p : pages) {
            max = Math.max(max, p);
            sum += p;
        }

        int start = max; // unlimited people
        int end = sum; // only 1 people
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isValid(pages, k, mid)) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public boolean isValid(int[] pages, int k, int limit) {
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

    public int copyBooks2(int[] pages, int k) {
        if (pages.length == 0) return 0;
        int max = pages[0];
        int sum = 0;
        for (int p : pages) {
            max = Math.max(max, p);
            sum += p;
        }
        if (k == 1) return sum;
        if (k >= pages.length) return max;

        int start = max;
        int end = sum;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isValid(pages, k, mid)) {
                if (mid == max || !isValid(pages, k, mid-1)) return mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
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
