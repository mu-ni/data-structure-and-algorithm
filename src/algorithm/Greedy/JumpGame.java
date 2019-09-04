package algorithm.Greedy;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJump2(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] nums) {
        int pos = 0;
        for (int i=0; i<nums.length; i++) {
            if (pos < i) return false;
            pos = Math.max(pos, i+nums[i]);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int pos = 0;
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            pos = Math.max(pos, i + nums[i]);
            if (i == max) {
                max = pos;
            }
        }
        return max >= nums.length-1;
    }
}
