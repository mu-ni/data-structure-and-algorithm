package algorithm.RecursionAndDP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,3}, 20));
        System.out.println(coinChange2(new int[]{1,2,5}, 11));
    }

    public static int coinChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));

        for (int i = 0; i < coins.length; ++i){
            dp[i][0] = 0;
        }

        for (int j = 1; j <= amount; ++j){
            if (j >= coins[0]){
                if (dp[0][j - coins[0]] == Integer.MAX_VALUE) {
                    continue;
                }
//                int a = dp[0][j - coins[0]] + 1;
//                int b = dp[0][j];
                dp[0][j] = Math.min(dp[0][j - coins[0]] + 1, dp[0][j]);
            }
        }

        for (int i=1; i<coins.length; ++i) {
            int coin = coins[i];
            for (int j=1; j<=amount; ++j) {
                if (j < coin || dp[i][j-coin] == Integer.MAX_VALUE) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coin]+1);
            }
        }
        return dp[coins.length-1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length-1][amount];
    }

    public static int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount+1]);
    }

    public static int helper(int[] coins, int remain, int[] count) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;
        if(count[remain] != 0) return count[remain];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, remain - coin, count);
            if (res >= 0 && res < min) {
                min = res+1;
            }
        }
        count[remain] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[remain];
    }

//    public static int rst = Integer.MAX_VALUE;
//    public static int coinChange2(int[] coins, int amount) { // works but slow
//        helper2(coins, amount, new ArrayList<>());
//        return rst == Integer.MAX_VALUE ? -1 : rst;
//    }
//
//    public static void helper2(int[] coins, int remain, List<Integer> path) {
//        if (remain < 0) return;
//        if (remain == 0 && path.size() < rst) {
//            rst = path.size();
//        }
//
//        for (int i=0; i<coins.length; i++) {
//            path.add(coins[i]);
//            helper2(coins, remain - coins[i], path);
//            path.remove(path.size()-1);
//        }
//    }
}
