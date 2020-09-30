package algorithm.Greedy;

/**
 * Created by muni on 2020/9/29
 */
public class MinOperationsMaxProfit {
    public static void main(String[] args) {
        System.out.println(new MinOperationsMaxProfit().minOperationsMaxProfit(new int[]{10,9,6}, 6, 4));
        System.out.println(new MinOperationsMaxProfit().minOperationsMaxProfit(new int[]{10,10,6,4,7}, 3, 8));
        System.out.println(new MinOperationsMaxProfit().minOperationsMaxProfit1(new int[]{10,9,6}, 6, 4));
        System.out.println(new MinOperationsMaxProfit().minOperationsMaxProfit1(new int[]{10,10,6,4,7}, 3, 8));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int run = 0;
        int maxRun = 0;
        int profit = 0;
        int maxProfit = 0;
        int sum = 0;
        for (int n : customers) {
            sum += n;
            int bd = Math.min(4, sum);
            sum -= bd;
            profit += bd*boardingCost - runningCost;
            run++;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxRun = run;
            }
        }

        while (sum > 0) {
            int bd = Math.min(4, sum);
            sum -= bd;
            profit += bd*boardingCost - runningCost;
            run++;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxRun = run;
            }
        }
        return maxProfit > 0 ? maxRun : -1;
    }

    public int minOperationsMaxProfit1(int[] customers, int boardingCost, int runningCost) {
        int run = 0;
        int maxRun = 0;
        int profit = 0;
        int maxProfit = 0;
        int sum = 0;
        int i = 0;
        while (sum > 0 || i < customers.length) {
            if (i < customers.length) sum += customers[i++];
            int bd = Math.min(4, sum);
            sum -= bd;
            profit += bd*boardingCost - runningCost;
            run++;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxRun = run;
            }
        }
        return maxProfit > 0 ? maxRun : -1;
    }
}
