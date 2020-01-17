package algorithm.RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by muni on 2020/1/17
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1,2,3}));
    }

    // n^3
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> rst = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            List<Integer> list = new ArrayList<>(Collections.singletonList(nums[i]));
            for (int n : nums) {
                if (isValid(list, n)) list.add(n);
            }
            if (list.size() > rst.size()) rst = list;
        }
        return rst;
    }

    private boolean isValid(List<Integer> list, int n) {
        if (list.contains(n)) return false;
        for (int num : list) {
            if (n%num != 0 && num%n != 0) return false;
        }
        return true;
    }
}
