package algorithm.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class JumpGame3 {
    public static void main(String[] args) {
        System.out.println(new JumpGame3().canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(new JumpGame3().canReach2(new int[]{4,2,3,0,3,1,2}, 5));
    }

    public boolean canReach(int[] arr, int start) {
        return backtrack(arr, start, new ArrayList<>());
    }

    public boolean backtrack(int[] arr, int pos, List<Integer> path) {
        if (pos < 0 || pos >= arr.length) return false;
        if (path.contains(pos)) return false;
        if (arr[pos] == 0) return true;

        int val = arr[pos];
        path.add(pos);
        boolean right = backtrack(arr, pos+val, path);
        boolean left = backtrack(arr, pos-val, path);
        path.remove(path.size()-1);
        return left || right;
    }

    public boolean canReach2(int[] arr, int start) {
        return backtrack(arr, start);
    }

    public boolean backtrack(int[] arr, int pos) {
        if (pos < 0 || pos >= arr.length) return false;
        if (arr[pos] == -1) return false;
        if (arr[pos] == 0) return true;

        int val = arr[pos];
        arr[pos] = -1;
        boolean right = backtrack(arr, pos+val);
        boolean left = backtrack(arr, pos-val);
        arr[pos] = val;
        return left || right;
    }
}
