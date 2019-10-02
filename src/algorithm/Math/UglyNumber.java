package algorithm.Math;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(6));
        System.out.println(new UglyNumber().isUgly2(6));
    }

    // prime factors only include 2, 3, 5
    public boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;

        while (num != 1) {
            if (num%2 == 0) {
                num /= 2;
            } else if (num%3 == 0) {
                num /= 3;
            } else if (num%5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isUgly2(int num) {
        if (num == 0) return false;
        if (num == 1) return true;

        if (num%2 == 0) {
            return isUgly(num/2);
        }
        if (num%3 == 0) {
            return isUgly(num/3);
        }
        if (num%5 == 0) {
            return isUgly(num/5);
        }
        return false;
    }
}
