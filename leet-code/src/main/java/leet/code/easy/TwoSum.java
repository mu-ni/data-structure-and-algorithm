package leet.code.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int[] rst = twoSum(nums, 22);
		
		System.out.println(java.util.Arrays.toString(rst));
	}

	public static int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			
			if(map.containsKey(temp) && map.get(temp) != i){
				return new int[]{i, map.get(temp)};
			}
		}
		
		throw new IllegalArgumentException("ERROR!");
	}
}
