package algorithm.Math;

import java.util.*;

public class UglyNumber3 {
    public static void main(String[] args) {
        System.out.println(new UglyNumber3().nthUglyNumber(4, 2, 3, 4));
        System.out.println(new UglyNumber3().nthUglyNumber2(4, 2, 3, 4));
        System.out.println(new UglyNumber3().nthUglyNumber3(4, 2, 3, 4));
    }

    // TLE
    public int nthUglyNumber(int n, int a, int b, int c) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(a * i);
            set.add(b * i);
            set.add(c * i);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(n - 1);
    }

    public int nthUglyNumber2(int n, int a, int b, int c) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        int rst = 0;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int count = count(a, b, c, mid);
            if (count < n) {
                left = mid+1;
            } else {
                rst = mid;
                right = mid-1;
            }
        }
        return rst;
    }

    public int nthUglyNumber3(int n, int a, int b, int c) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int count = count(a, b, c, mid);
            if (count < n) {
                left = mid+1;
            } else {
                if (mid == left || count(a, b, c, mid-1) < n) return mid;
                right = mid-1;
            }
        }
        return -1;
    }

    // how many numbers from 1 to num are divisible by either a, b or c
    private int count(long a, long b, long c, long num) {
        return (int) (num/a + num/b + num/c - num/lcm(a,b) - num/lcm(b,c) - num/lcm(a,c) + num/lcm(a, lcm(b,c)));
    }

    private long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    private long lcm(long a, long b) {
        return (a*b)/gcd(a, b);
    }
}
