package algorithm.ArrayAndString.BoyerMoore;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    // appears > len/2
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (candidate == nums[i]) {
                count++;
            } else {
                count --;
            }
        }
        return candidate;
    }
}
