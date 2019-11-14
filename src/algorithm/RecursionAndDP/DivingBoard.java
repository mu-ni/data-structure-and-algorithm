package algorithm.RecursionAndDP;

import java.util.HashSet;
import java.util.Set;

public class DivingBoard {
    public static void main(String[] args) {
        System.out.println(new DivingBoard().allLengths(3, 5, 10));
    }

    // O(2^k)
    public Set<Integer> allLengths(int k, int shorter, int longer) {
        if (k == 0) return new HashSet<>();

        Set<Integer> rst = new HashSet<>();
        dfs(rst, k, shorter, longer, 0);
        return rst;
    }

    public void dfs(Set<Integer> rst, int k, int shorter, int longer, int len) {
        if (k == 0) {
            rst.add(len);
            return;
        }

        dfs(rst, k-1, shorter, longer, len + shorter);
        dfs(rst, k-1, shorter, longer, len + longer);
    }
}
