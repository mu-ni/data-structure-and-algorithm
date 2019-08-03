package algorithm.recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.print(climb(5));
    }

    public static int climb(int n) {
        if(n < 0) {
            return Integer.MIN_VALUE;
        }
        if (n <= 2) {
            return n;
        }
        return climb(n - 1) + climb(n - 2);
    }
}
