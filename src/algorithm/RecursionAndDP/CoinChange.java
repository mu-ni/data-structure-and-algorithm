package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 30));
        System.out.println(coinChange2(new int[]{1,2,5}, 30));
    }

    public static int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount]);
    }

    public static int helper(int[] coins, int remain, int[] count) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;
        if(count[remain-1] != 0) return count[remain-1];

        int min = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++) {
            int res = helper(coins, remain - coins[i], count);
            if (res >= 0 && res < min) {
                min = res+1;
            }
        }
        count[remain-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[remain-1];
    }

    public static int rst = Integer.MAX_VALUE;
    public static int coinChange2(int[] coins, int amount) { // work but slow
        helper2(coins, amount, new ArrayList<>());
        return rst == Integer.MAX_VALUE ? -1 : rst;
    }

    public static void helper2(int[] coins, int remain, List<Integer> path) {
        if (remain < 0) return;
        if (remain == 0 && path.size() < rst) {
            rst = path.size();
        }

        for (int i=0; i<coins.length; i++) {
            path.add(coins[i]);
            helper2(coins, remain - coins[i], path);
            path.remove(path.size()-1);
        }
    }
}
