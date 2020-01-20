package algorithm.ArrayAndString.Stock;

/**
 * Created by muni on 2020/1/20
 */
public class WithTransactionFee {
    public static void main(String[] args) {
        System.out.println(new WithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(new WithTransactionFee().maxProfit2(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int[] hold = new int[len];     //Till day i, the max profit is hold[i] if I hold the stock.
        int[] notHold = new int[len];  //Till day i, the max profit is notHold[i] if I do not hold the stock.

        hold[0] = -prices[0];
        notHold[0] = 0;

        for (int i = 1; i < len; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] - fee + prices[i]);
        }

        return notHold[len - 1];
    }

    public int maxProfit2(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int hold = -prices[0];
        int notHold = 0;

        for (int i = 1; i < len; i++) {
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, hold + prices[i] - fee);
        }

        return notHold;
    }
}
