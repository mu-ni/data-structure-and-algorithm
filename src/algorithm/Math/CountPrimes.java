package algorithm.Math;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
        System.out.println(new CountPrimes().countPrimes2(10));
        System.out.println(new CountPrimes().countPrimes3(10));
    }

    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i=2; i<n; i++) {
            if (notPrime[i]) continue;
            count++;
            for (int j=i; j<n; j += i) {
                notPrime[j] = true;
            }
        }
        return count;
    }

    // TLE
    public int countPrimes2(int n) {
        int count = 0;
        for (int i=2; i<n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    public boolean isPrime(int n) {
        for (int i=2; i<n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }

    public int countPrimes3(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i=2; i<n; i++) {
            if (isPrime[i]) count++;
            for (int j=i; j<n; j += i) {
                isPrime[j] = false;
            }
        }
        return count;
    }
}
