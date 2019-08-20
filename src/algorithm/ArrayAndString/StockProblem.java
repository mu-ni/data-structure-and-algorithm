package algorithm.ArrayAndString;

public class StockProblem {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    // one transaction
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int max = 0;
        for (int cur : prices) {
            max = Math.max(max, cur - min);
            min = Math.min(min, cur);
        }
        return max;
    }
}
