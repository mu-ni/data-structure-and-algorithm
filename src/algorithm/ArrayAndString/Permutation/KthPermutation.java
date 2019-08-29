package algorithm.ArrayAndString.Permutation;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    public static void main(String[] args) {
        System.out.println(new KthPermutation().getPermutation(3, 3));
    }

    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            list.add(String.valueOf(i));
        }

        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i=1; i<=n; i++) {
            factorial[i] = factorial[i-1]*i;
        }

        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            int index = k/factorial[n-i];
            sb.append(list.get(index));
            list.remove(index);
            k = k%factorial[n-i];
        }

        return sb.toString();
    }

}
