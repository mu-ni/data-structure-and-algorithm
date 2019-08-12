package algorithm.RecursionAndDP;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climb(25));
        System.out.println(climb2(25));
        System.out.println(climb3(25));
        System.out.println(climb4(25));
    }

    // recursion
    // time complexity O(2^n)
    // space complexity O(n)
    public static int climb(int n) {
        if (n <= 2) return n;
        return climb(n-1) + climb(n-2);
    }

    // DP Top Down
    // time complexity O(n)
    // space complexity O(n)
    static int[] arr = new int[128];
    public static int climb2(int n) {
        if (n <= 2) return n;
        if(arr[n] > 0) {
            return arr[n];
        }
        return arr[n] = climb2(n-1) + climb2(n-2);
    }

    // iteration
    // time complexity O(n)
    // space complexity O(1)
    public static int climb3(int n) {
        if (n <= 2) return n;
        int a = 1;
        int b = 2;
        for (int i=3; i<=n; i++) {
            int sum = a+b;
            a = b;
            b = sum;
        }
        return b;
    }

    // DP Down Top
    // time complexity O(n)
    // space complexity O(n)
    public static int climb4(int n) {
        if (n <= 2) return n;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i=3; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
