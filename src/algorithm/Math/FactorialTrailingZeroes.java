package algorithm.Math;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(5));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes2(5));
    }

    public int trailingZeroes(int n) {
        int rst = 0;
        while (n > 0) {
            rst += n/5;
            n /= 5;
        }
        return rst;
    }

    public int trailingZeroes2(int n) {
        if (n < 5) return 0;
        return n/5 + trailingZeroes2(n/5);
    }
}
