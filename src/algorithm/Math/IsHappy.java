package algorithm.Math;

public class IsHappy {
    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(19));
        System.out.println(new IsHappy().isHappy(2));
    }

    public boolean isHappy(int n) {
        int x = n;
        int y = helper(n);
        while (x != y) {
            x = helper(x);
            y = helper(helper(y));
        }
        return x == 1;
    }

    public int helper(int n) {
        int num = 0;
        while (n != 0) {
            num += Math.pow(n%10, 2);
            n /= 10;
        }
        return num;
    }
}
