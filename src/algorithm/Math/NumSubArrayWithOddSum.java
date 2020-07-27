package algorithm.Math;

/**
 * Created by muni on 2020/7/27
 */
public class NumSubArrayWithOddSum {
    public static void main(String[] args) {
        System.out.println(new NumSubArrayWithOddSum().numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(new NumSubArrayWithOddSum().numOfSubarrays2(new int[]{1, 3, 5}));
        System.out.println(new NumSubArrayWithOddSum().numOfSubarrays3(new int[]{1, 3, 5}));
    }

    // ???
    public int numOfSubarrays(int[] arr) {
        int rst = 0;
        int cur = 0;
        int mod = (int) (1e9 + 7);
        int[] count = new int[]{1, 0};
        for (int n : arr) {
            cur ^= n & 1;
            rst = (rst + count[1 - cur]) % mod;
            count[cur]++;
        }
        return rst;
    }

    public int numOfSubarrays2(int[] arr) {
        int n = arr.length;
        int mod = (int) (1e9 + 7);
        int[] dp0 = new int[n];
        dp0[n - 1] = arr[n - 1] % 2 == 0 ? 1 : 0;
        int[] dp1 = new int[n];
        dp1[n - 1] = arr[n - 1] % 2 == 1 ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] % 2 == 0) {
                dp1[i] = dp1[i + 1];
                dp0[i] = dp0[i + 1] + 1;
            } else {
                dp0[i] = dp1[i + 1];
                dp1[i] = dp0[i + 1] + 1;
            }
        }

        long sum = 0;
        for (int num : dp1) {
            sum += num;
        }
        return (int) (sum % mod);
    }

    public int numOfSubarrays3(int[] arr) {
        long count = 0;
        int even = 0;
        int odd = 0;
        int mod = (int) (1e9 + 7);
        for (int n : arr) {
            if (n % 2 == 0) {
                even++;
            } else {
                int tmp = odd;
                odd = even + 1;
                even = tmp;
            }
            count += odd;
        }
        return (int) (count % mod);
    }
}
