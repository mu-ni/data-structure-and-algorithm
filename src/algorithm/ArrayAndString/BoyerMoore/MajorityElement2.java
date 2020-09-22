package algorithm.ArrayAndString.BoyerMoore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by muni on 2020/9/22
 */
public class MajorityElement2 {
    public static void main(String[] args) {
        System.out.println(new MajorityElement2().majorityElement(new int[]{1,2}));
        System.out.println(new MajorityElement2().majorityElement(new int[]{3,2,3}));
        System.out.println(new MajorityElement2().majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }

    // O(n) time complexity
    // O(1) space complexity
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        int n1 = nums[0];
        int c1 = 0;
        int n2 = nums[0];
        int c2 = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == n1) {
                c1++;
            } else if (nums[i] == n2) {
                c2++;
            } else if (c1 == 0) {
                n1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                n2 = nums[i];
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int n : nums) {
            if (n == n1) c1++;
            if (n == n2) c2++;
        }

        Set<Integer> set = new HashSet<>();
        if (c1 > nums.length/3) set.add(n1);
        if (c2 > nums.length/3) set.add(n2);
        return new ArrayList<>(set);
    }
}
