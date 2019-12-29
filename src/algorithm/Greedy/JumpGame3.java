package algorithm.Greedy;

import java.util.ArrayList;
import java.util.List;

public class JumpGame3 {
    public static void main(String[] args) {
        System.out.println(new JumpGame3().canReach(new int[]{4,2,3,0,3,1,2}, 5));
    }

    public boolean canReach(int[] arr, int start) {
        return backtrack(arr, start, new ArrayList<>());
    }

    public boolean backtrack(int[] arr, int pos, List<Integer> path) {
        if (pos < 0 || pos >= arr.length) return false;
        if (path.contains(pos)) return false;
        if (arr[pos] == 0) return true;
        path.add(pos);

        int val = arr[pos];
        pos += val;
        boolean right = backtrack(arr, pos, path);
        pos -= 2*val;
        boolean left = backtrack(arr, pos, path);
        pos += val;

        return left || right;
    }
}
