package algorithm.RecursionAndDP;

import java.util.HashSet;
import java.util.Set;

public class DivingBoard {
    public static void main(String[] args) {
        System.out.println(new DivingBoard().allLengths(3, 5, 10));
        System.out.println(new DivingBoard().allLengths2(3, 5, 10));
        System.out.println(new DivingBoard().allLengths3(3, 5, 10));
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

    // O(k^2)
    public Set<Integer> allLengths2(int k, int shorter, int longer) {
        if (k == 0) return new HashSet<>();

        Set<Integer> rst = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        dfs(rst, visited, k, shorter, longer, 0);
        return rst;
    }

    public void dfs(Set<Integer> rst, Set<Integer> visited, int k, int shorter, int longer, int len) {
        if (k == 0) {
            rst.add(len);
            return;
        }

        if (visited.contains(len)) return;
        dfs(rst, k-1, shorter, longer, len + shorter);
        dfs(rst, k-1, shorter, longer, len + longer);
        visited.add(len);
    }

    public Set<Integer> allLengths3(int k, int shorter, int longer) {
        if (k == 0) return new HashSet<>();

        Set<Integer> rst = new HashSet<>();
        for (int i=0; i<=k; i++) {
            int len = i*shorter + (k-i)*longer;
            rst.add(len);
        }
        return rst;
    }
}
