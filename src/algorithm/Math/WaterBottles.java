package algorithm.Math;

/**
 * Created by muni on 2020/7/21
 */
public class WaterBottles {
    public static void main(String[] args) {
        System.out.println(new WaterBottles().numWaterBottles(9, 3));
        System.out.println(new WaterBottles().numWaterBottles(15, 4));
        System.out.println(new WaterBottles().numWaterBottles(15, 8));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        int rem = 0;
        while (numBottles > 0) {
            count += numBottles;
            int sum = numBottles + rem;
            numBottles = sum/numExchange;
            rem = sum%numExchange;
        }
        return count;
    }
}
