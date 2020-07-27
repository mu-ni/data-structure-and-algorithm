package algorithm.Math;

/**
 * Created by muni on 2020/7/27
 */
public class NumSubArrayWithOddSum {
    public static void main(String[] args) {
        System.out.println(new NumSubArrayWithOddSum().numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(new NumSubArrayWithOddSum().numOfSubarrays2(new int[]{1, 3, 5}));
    }

    public int numOfSubarrays(int[] arr) {
        int count = 0;
        int even = 0;
        int odd = 0;
        int mod = (int) (1e9+7);
        for (int n : arr) {
            if (n % 2 == 0) {
                even++;
            } else {
                int tmp = odd;
                odd = even + 1;
                even = tmp;
            }
            count = (count + odd) % mod;
        }
        return count;
    }

    public int numOfSubarrays2(int[] arr) {
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
}
