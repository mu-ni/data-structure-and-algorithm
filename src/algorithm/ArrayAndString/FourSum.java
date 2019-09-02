package algorithm.ArrayAndString;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(fourSum2(new int[]{1,0,-1,0,-2,2}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> rst = new HashSet<>();
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int left = j+1;
                int right = nums.length-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                        continue;
                    }
                    if (sum > target) {
                        right--;
                        continue;
                    }
                    rst.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        return new ArrayList<>(rst);
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        for (int i=0; i<nums.length-1; i++) {
            if (i !=0 && nums[i] == nums[i-1]) continue;
            for (int j=i+1; j<nums.length; j++) {
                if (j !=i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                        continue;
                    }
                    if (sum > target) {
                        right--;
                        continue;
                    }
                    rst.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
            }
        }
        return rst;
    }
}
