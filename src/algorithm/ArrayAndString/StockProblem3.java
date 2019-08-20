package algorithm.ArrayAndString;

public class StockProblem3 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    // at most two transactions
    public static int maxProfit(int[] prices) {
        int b1 = Integer.MAX_VALUE; //1 buy
        int sum1 = 0;//1 buy 1 sell
        int b2 = Integer.MAX_VALUE;//2 buy
        int sum2 = 0;//2 buy 2 sell
        for (int p : prices) {
            b1 = Math.min(b1, p);
            sum1 = Math.max(sum1, p - b1);
            b2 = Math.min(b2, p - sum1);
            sum2 = Math.max(sum2, p - b2);
            System.out.println(b1 + "," + sum1 + "," + b2 + "," + sum2);
        }

        return sum2;
    }
}
