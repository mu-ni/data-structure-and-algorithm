package algorithm.Math;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(2147395599));
        System.out.println(new Sqrt().mySqrt2(2147395599));
        System.out.println(new Sqrt().mySqrt3(2147395599));
        System.out.println(new Sqrt().mySqrt4(2147395599));
    }

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long rst = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sqr = mid * mid;
            if (sqr == x) return (int) mid;
            if (sqr > x) {
                right = mid - 1;
            } else {
                rst = mid;
                left = mid + 1;
            }
        }
        return (int) rst;
    }

    public int mySqrt2(int x) {
        int l = 1;
        int r = x;
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2; // no integer overflow
            int div = x / mid; // no integer overflow
            if (div == mid) return mid;
            if (div < mid) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public int mySqrt3(int x) {
        long start = 0;
        long end = x;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sqr = mid * mid;
            if (sqr == x) return (int) mid;
            if (sqr < x) {
                if ((mid + 1) * (mid + 1) > x) return (int) mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int mySqrt4(int x) {
        if (x <= 1) return x;
        int start = 0;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (x/mid == mid) return mid;
            if (x/mid > mid) {
                if (x/(mid+1) < (mid+1)) return mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
