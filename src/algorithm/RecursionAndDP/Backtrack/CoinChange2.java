package algorithm.RecursionAndDP.Backtrack;

public class CoinChange2 { //combinations make up amount
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,3}, 5));
        System.out.println(coinChange2(new int[]{1,2,3}, 5));
        System.out.println(coinChange3(new int[]{1,2,3}, 5));
    }

    // O(m*n)
    // O(m*n)
    public static int coinChange(int[] coins, int amount) { // 2d array
        int[][] dp = new int[coins.length+1][amount+1];

        for (int i = 0; i<=coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<=coins.length; i++) {
            int coin = coins[i-1]; // first value index is 1
            for (int j=1; j<=amount; j++) {
                if (j-coin < 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-coin];
            }
        }
        return dp[coins.length][amount];
    }

    public static int coinChange2(int[] coins, int amount) { // use repeated coins
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i=coin; i<=amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

//    increasing i then the previous partial result dp[i - coin] is the result that has considered coin already
//    decreasing i then the previous partial result dp[i - coin] is the result that has not considered coin yet
    public static int coinChange3(int[] coins, int amount) { // use non-repeated coins
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i=amount; i>=coin; i--) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
