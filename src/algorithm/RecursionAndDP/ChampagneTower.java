package algorithm.RecursionAndDP;

/**
 * Created by muni on 2020/10/26
 */
public class ChampagneTower {
    public static void main(String[] args) {
        System.out.println(new ChampagneTower().champagneTower(2, 1, 1));
        System.out.println(new ChampagneTower().champagneTower2(2, 1, 1));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][query_row+1];
        dp[0][0] = poured;
        for (int i=0; i<query_row; i++) {
            for (int j=0; j<=i; j++) {
                if (dp[i][j] < 1) continue;
                double overflow = (dp[i][j] - 1)/2;
                dp[i+1][j] += overflow;
                dp[i+1][j+1] += overflow;
                dp[i][j] = 1;
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }

    public double champagneTower2(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row+1];
        dp[0] = poured;
        for (int i=0; i<query_row; i++) {
            for (int j = i; j>=0; j--) {
                double overflow = Math.max (0, (dp[j] - 1)/2);
                dp[j + 1] += overflow;
                dp[j] = overflow;
            }
        }
        return Math.min(1.0, dp[query_glass]);
    }
}
