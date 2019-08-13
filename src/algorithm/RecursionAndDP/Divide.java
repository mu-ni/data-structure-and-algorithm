package algorithm.RecursionAndDP;

public class Divide {
    public static void main(String[] args) {
        System.out.println(divide(123, 45));
        System.out.println(divide(20, 20));
        System.out.println(divide(0, 20));
        System.out.println(divide(40, 10));
        System.out.println(divide(7, -3));
        System.out.println(divide(7, 0));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            // error
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) return dividend;

        if (dividend <= 0 && divisor > 0 || dividend >= 0 && divisor < 0) {
            return -divide(Math.abs(dividend), Math.abs(divisor), 0);
        }
        return divide(dividend, divisor, 0);
    }

    public static int divide(int num1, int num2, int rst) {
        if (num1 == num2) {
            return rst + 1;
        }
        if (num1 < num2) {
            return rst;
        }
        return divide(num1 - num2, num2, rst + 1);
    }
}
