package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMinPath {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(new TriangleMinPath().minimumTotal(triangle));
        System.out.println(new TriangleMinPath().minimumTotal2(triangle));
        System.out.println(new TriangleMinPath().minimumTotal3(triangle));
        System.out.println(new TriangleMinPath().minimumTotal4(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++) {
            for (int j=0; j<=i; j++) {
                int num = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + num;
                    continue;
                }
                if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + num;
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + num;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : dp[n-1]) {
            min = Math.min(min, i);
        }
        return min;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++) {
            for (int j = i; j >=0; j--) {
                int num = triangle.get(i).get(j);
                if (j == 0) {
                    dp[j] += num;
                    continue;
                }
                if (j == i) {
                    dp[j] += dp[j-1] + num;
                    continue;
                }
                dp[j] = Math.min(dp[j-1], dp[j]) + num;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i : dp) {
            min = Math.min(min, i);
        }
        return min;
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];

        dp[0][0] = triangle.get(0).get(0);
        for (int i=1; i<m; i++) {
            for (int j=0; j<=i; j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                } else if (j == i) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int n : dp[m-1]) {
            min = Math.min(min, n);
        }
        return min;
    }

    public int minimumTotal4(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];

        dp[0] = triangle.get(0).get(0);
        for (int i=1; i<m; i++) {
            for (int j=i; j>=0; j--) {
                if (j == 0) {
                    dp[j] = triangle.get(i).get(j) + dp[j];
                } else if (j == i) {
                    dp[j] = triangle.get(i).get(j) + dp[j-1];
                } else {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j-1], dp[j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int n : dp) {
            min = Math.min(min, n);
        }
        return min;
    }
}
