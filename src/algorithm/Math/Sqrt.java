package algorithm.Math;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(2147395599));
        System.out.println(new Sqrt().mySqrt2(2147395599));
    }

    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        int ans = 0;
        while (l <= r) {
            long mid = (l+r)/2;
            long sqa = mid*mid;
            if (sqa == x) return (int) mid;
            if (sqa < x) {
                ans = (int) mid;
                l = (int) (mid+1);
            } else {
                r = (int) (mid-1);
            }
        }
        return ans;
    }

    public int mySqrt2(int x) {
        int l = 1;
        int r = x;
        int ans = 0;
        while (l <= r) {
            int mid = l+(r-l)/2; // no integer overflow
            int div = x/mid; // no integer overflow
            if (div == mid) return mid;
            if (div < mid) {
                r = mid-1;
            } else {
                ans = mid;
                l = mid+1;
            }
        }
        return ans;
    }
}
