package algorithm.RecursionAndDP;

public class Divide {
    public static void main(String[] args) {
        System.out.println(divide(123, 45));
        System.out.println(divide2(10, 3));
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
        return helper(dividend, divisor, rst + 1);
    }

    public static int divide2(int dividend, int divisor) {
        if ((dividend == Integer.MIN_VALUE) && divisor == -1) return Integer.MAX_VALUE;
//        if (divisor == 1) return dividend;
//        if (dividend == 0) return 0;

        boolean isNegative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNegative = true;
        }

        long dend = Math.abs((long) dividend);
        long sor = Math.abs((long) divisor);

        int result = 0;
        long sum = sor;
        int count = 1;
        while (dend >= sor) {
            if (dend > sum) {
                sum += sum;
                count += count;
            }
            if (dend < sum) {
                sum = sor;
                count = 1;
            }
            dend -= sum;
            result += count;
        }

        return isNegative ? -result : result;
    }
}