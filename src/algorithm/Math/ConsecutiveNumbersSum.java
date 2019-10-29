package algorithm.Math;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(15));
    }

    // N = k + (k+1) + (k+2) + (k+3) + ... + (k+i-1) = i*k + (1+2+3+... + i-1)
    public int consecutiveNumbersSum(int N) {
        int rst = 0;
        int sum = 0;
        for (int i = 1; sum < N; i++) {
            sum += i;
            if ((N - sum) % i == 0) {
                rst++;
            }
        }
        return rst;
    }
}
