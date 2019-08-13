package algorithm.RecursionAndDP;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{1,2,5}, 100));
    }

    public static int rst = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);// REVERSE
        helper(coins, amount, new ArrayList<>());
        return rst == Integer.MAX_VALUE ? -1 : rst;
    }

    public static void helper(int[] coins, int remain, List<Integer> path) {
        if (remain < 0) return;
        if (remain == 0 && path.size() < rst) {
            rst = path.size();
        }

        for (int i=0; i<coins.length; i++) {
            path.add(coins[i]);
            helper(coins, remain - coins[i], path);
            path.remove(path.size()-1);
        }
    }
}
