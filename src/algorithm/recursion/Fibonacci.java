package algorithm.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print(fib(5));
    }

    // recursion
    // time complexity O(2^n)
    // space complexity O(n)
    public static int fib(int n) {
        if(n < 0) {
            return Integer.MIN_VALUE; // error
        }
        if(n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


}
