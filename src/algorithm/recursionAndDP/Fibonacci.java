package algorithm.recursionAndDP;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print(fib(5));
    }

    // recursion
    // time complexity O(2^n)
    // space complexity O(n)
//    public static int fib(int n) {
//        if(n < 0) {
//            return Integer.MIN_VALUE; // error
//        }
//        if(n <= 1) {
//            return n;
//        }
//        return fib(n - 1) + fib(n - 2);
//    }

    // iteration
    // time complexity O(n)
    // space complexity O(1)
//    public static int fib(int n) {
//        if(n < 0) {
//            return Integer.MIN_VALUE; // error
//        }
//        if(n <= 1) {
//            return n;
//        }
//
//        int a = 0, b = 1;
//        while(n > 1) {
//            int sum = a+b;
//            a = b;
//            b = sum;
//            n--;
//        }
//        return b;
//    }

    // dynamic programming - Top Down Approach
    // time complexity O(n)
    // space complexity O(n)
//    static int[] arr = new int[128];
//    public static int fib(int n) {
//        if(n < 0) {
//            return Integer.MIN_VALUE; // error
//        }
//        if(n <= 1) {
//            return n;
//        }
//        if(arr[n] > 0) {
//            return arr[n];
//        }
//
//        return arr[n] = fib(n-1) + fib(n-2);
//    }

    // dynamic programming - Down Top Approach
    // time complexity O(n)
    // space complexity O(n)
    public static int fib(int n) {
        if(n < 0) {
            return Integer.MIN_VALUE; // error
        }
        if(n <= 1) {
            return n;
        }

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
