package algorithm.ArrayAndString.Stock;

/**
 * Created by muni on 2020/7/29
 */
public class WithCooldown {
    public static void main(String[] args) {
        System.out.println(new WithCooldown().maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(new WithCooldown().maxProfit2(new int[]{1,2,3,0,2}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[] buy = new int[n]; // transaction end with buy
        int[] sell = new int[n]; // transaction end with sell
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[1] = Math.max(0, prices[1] - prices[0]);

        for (int i=2; i<n; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[n-1];
    }

    // ???
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0; s2 = s1; s1 = s0;
        }
        return s0;
    }
}
