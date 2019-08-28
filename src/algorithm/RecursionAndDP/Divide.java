package algorithm.RecursionAndDP;

public class Divide {
    public static void main(String[] args) {
        System.out.println(divide(123, 45));
        System.out.println(divide(20, 20));
        System.out.println(divide(0, 20));
        System.out.println(divide(40, 10));
        System.out.println(divide(7, -3));
        System.out.println(divide(7, 0));
        System.out.println(divide(10, 3));
    }

    public static int divide(int dividend, int divisor) { // 2147483647/2 -> stack overflow
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;

        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            return helper(Math.abs(dividend), Math.abs(divisor), 0);
        }
        return -helper(Math.abs(dividend), Math.abs(divisor), 0);
    }

    public static int helper(int dividend, int divisor, int rst) {
        dividend -= divisor;
        if (dividend < 0) {
            return rst;
        }
        return helper(dividend, divisor, rst+1);
    }

}
