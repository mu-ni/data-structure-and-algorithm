package algorithm.Math;

public class RotatedDigits {
    public static void main(String[] args) {
        System.out.println(new RotatedDigits().rotatedDigits(857));
    }

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i=1; i<=N; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isValid(int n) {
        boolean isValid = false;
        while (n > 0) {
            int mod = n%10;
            if (mod == 3 || mod == 4 || mod == 7) {
                return false;
            }
            if (mod == 2 || mod == 5 || mod == 6 || mod == 9) {
                isValid = true;
            }
            n /= 10;
        }
        return isValid;
    }
}
