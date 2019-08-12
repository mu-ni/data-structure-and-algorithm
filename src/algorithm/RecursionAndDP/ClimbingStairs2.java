package algorithm.RecursionAndDP;

public class ClimbingStairs2 {
    public static void main(String[] args) {
        System.out.println(climb(25));
        System.out.println(climb2(25));
        System.out.println(climb3(25));
        System.out.println(climb4(25));
    }

    // recursion
    // time complexity O(3^n)
    // space complexity O(n)
    public static int climb(int n) {
        if(n <= 0) {
            return Integer.MIN_VALUE; // error
        }
        if (n <= 2) {
            return n;
        }
        if(n == 3) {
            return 4;
        }
        return climb(n - 1) + climb(n - 2) + climb(n - 3);
    }

    // DP Top Down
    // time complexity O(n)
    // space complexity O(n)
    static int[] arr = new int[128];
    public static int climb2(int n) {
        if (n <= 0) {
            return Integer.MIN_VALUE; // error
        }
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        if(arr[n] > 0) {
            return arr[n];
        }

        return arr[n] = climb2(n - 1) + climb2(n - 2) + climb2(n - 3);
    }

    // iteration
    // time complexity O(n)
    // space complexity O(1)
    public static int climb3(int n) {
        if(n <= 0) {
            return Integer.MIN_VALUE; // error
        }
        if (n <= 2) {
            return n;
        }
        if(n == 3) {
            return 4;
        }

        int a = 1;
        int b = 2;
        int c = 4;
        for (int i = 4; i<= n; i++) {
            int sum = a+b+c;
            int tmp = c;
            c = sum;
            b = sum - a - b;
            a = sum - a - tmp;
        }
        return c;
    }

    // DP Down Top
    // time complexity O(n)
    // space complexity O(n)
    public static int climb4(int n) {
        if (n <= 0) {
            return Integer.MIN_VALUE; // error
        }
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        if(arr[n] > 0) {
            return arr[n];
        }
        for(int i=4; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        return arr[n];
    }
}
