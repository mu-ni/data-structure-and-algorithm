package algorithm.RecursionAndDP;

public class Pow {
    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0, 10));
        System.out.println(new Pow().myPow(2.0, -2));
        System.out.println(new Pow().myPow2(2.0, 10));
        System.out.println(new Pow().myPow2(2.0, -2));
    }

    public double myPow(double x, int n) {
        if (n > 0) return posPow(x, n);
        if (n < 0) return negPow(x, n);
        return 1;
    }

    public double posPow(double x, int n) {
        if (n == 1) return x;
        return x * posPow(x, n - 1);
    }

    public double negPow(double x, int n) {
        if (n == -1) return 1 / x;
        return 1 / x * negPow(x, n + 1);
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == 2) return x * x;
//        if (n < 0) {
//            n = -n;
//            x = 1/x;
//        }
        if (n < 0) return 1 / x * myPow(1 / x, -(n + 1));

        if (n % 2 == 0) {
            return myPow2(myPow2(x, n / 2), 2);
        }
        return x * myPow2(myPow2(x, n / 2), 2);
    }
}
