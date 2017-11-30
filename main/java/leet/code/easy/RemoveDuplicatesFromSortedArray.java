package leet.code.easy;


public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,2,3,3,4,4,4};
		System.out.println(getLength(nums));
	}

	public static int getLength(int[] nums){
		
		if(nums.length == 0){
			return 0;
		}
		
		int i = 0;
		for(int j=0;j<nums.length;j++){
			if(nums[i] != nums[j]){
				i++;
				nums[i] = nums[j];
			}
		}
		
		return i+1;
		
	}
}
