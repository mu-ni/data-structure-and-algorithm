package algorithm.RecursionAndDP;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by muni on 2020/1/16
 */
public class CountNumberWithUniqueDigit {
    public static void main(String[] args) {
        System.out.println(new CountNumberWithUniqueDigit().countNumbersWithUniqueDigits(2));
        System.out.println(new CountNumberWithUniqueDigit().countNumbersWithUniqueDigits2(2));
    }

    // TLE
    // 0 <= x < 10^n
    public int countNumbersWithUniqueDigits(int n) {
        int max = (int)Math.pow(10, n);
        int count = max;
        for (int i=10; i<max; i++) {
            if (!isUnique(i)) count--;
        }
        return count;
    }

    public boolean isUnique(int n) {
        Set<Integer> set = new HashSet<>();
        while (n > 0) {
            if (set.contains(n%10)) return false;
            set.add(n%10);
            n /= 10;
        }
        return true;
    }

    // math -> don't understand
    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, base = 9;
        for (int i = 2; i <= Math.min(10, n); i++) {
            base = base * (9 - i + 2);
            ans += base;
        }
        return ans;
    }

}
