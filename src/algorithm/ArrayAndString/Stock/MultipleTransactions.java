package algorithm.ArrayAndString.Stock;

public class MultipleTransactions {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
    }

    // multiple transactions
    public static int maxProfit(int[] prices) { // greedy
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(prices[i]-prices[i-1], 0);
        }
        return sum;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
