package algorithm.RecursionAndDP;

public class CoinChange2 { //combinations make up amount
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,3}, 5));
        System.out.println(coinChange2(new int[]{1,2,3}, 6));
    }

//    increasing i then the previous partial result dp[i - coin] is the result that has considered coin already
//    decreasing i then the previous partial result dp[i - coin] is the result that has not considered coin yet

    public static int coinChange(int[] coins, int amount) { // use repeated coins
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i=coin; i<=amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }


    public static int coinChange2(int[] coins, int amount) { // use non-repeated coins
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
