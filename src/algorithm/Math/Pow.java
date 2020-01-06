package algorithm.Math;

public class Pow {
    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0, 10));
        System.out.println(new Pow().myPow(2.0, -2));
        System.out.println(new Pow().myPow2(2.0, 10));
        System.out.println(new Pow().myPow2(2.0, -2));
        System.out.println(new Pow().myPow3(2.0, 10));
        System.out.println(new Pow().myPow3(2.0, -2));
        System.out.println(new Pow().myPow4(2.0, 10));
        System.out.println(new Pow().myPow4(2.0, -2));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == 2) return x*x;

        if (n == Integer.MIN_VALUE) {
            return 1/x*myPow(1/x, -(n+1));
        }
        if (n < 0) {
            return myPow(1/x, -n);
        }

        if (n%2 == 0) {
            return myPow(myPow(x, n/2), 2);
        }
        return x*myPow(myPow(x, n/2), 2);
    }


    public double myPow2(double x, int n) {
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

    public double myPow3(double x, int n) {
        if (n == 0) return 1;

        if (n < 0) {
            x = 1/x;
            n = -n;
        }

        double prod = x;
        double rst = 1;
        for (int i=n; i> 0; i /= 2) {
            if (i%2 == 1) {
                rst = rst*prod;
            }
            prod = prod*prod;
        }
        return rst;
    }

    // TLE
    public double myPow4(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == 2) return x*x;

        if (n < 0) return myPow4(1/x, -n); // Integer.MIN_VALUE overflow

        if (n%2 == 0) {
            return myPow4(x, n/2)*myPow4(x, n/2);
        }
        return x*myPow4(x, n/2)*myPow4(x, n/2);
    }
}
