package algorithm.ArrayAndString.Permutation;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    public static void main(String[] args) {
        System.out.println(new KthPermutation().getPermutation2(4, 5));
    }

    public String getPermutation2(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        k--;
        while (n > 0) {
            int i = k / factorial[n - 1];
            k = k % factorial[n - 1];
            sb.append(list.remove(i));
            n--;
        }

        return sb.toString();
    }

}
