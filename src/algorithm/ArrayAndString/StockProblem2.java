package algorithm.ArrayAndString;

public class StockProblem2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    // multiple transactions
    public static int maxProfit(int[] prices) { // greedy
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(prices[i]-prices[i-1], 0);
        }
        return sum;
    }
}
