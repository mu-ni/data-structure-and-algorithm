package algorithm.ArrayAndString;

import java.util.Arrays;

public class StockProblem4 {
    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

    // at most k transactions
    public static int maxProfit(int k, int[] prices) {
        if (k >= prices.length/2) return greedy(prices);

        int[] buy = new int[k+1];
        Arrays.fill(buy,Integer.MAX_VALUE);
        int[] sell = new int[k+1];

        for (int price : prices) {
            for (int i=k; i>=1; i--) {
                buy[i] = Math.min(buy[i], price - sell[i-1]);
                sell[i] = Math.max(sell[i], price - buy[i]);
            }
        }
        return sell[k];
    }

    public static int greedy(int[] prices) {
        int profit = 0;
        for (int i=1; i<prices.length; i++) {
            profit += Math.max(prices[i]-prices[i-1], 0);
        }
        return profit;
    }
}
