package algorithm.Greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame2().jump(new int[]{3,2,1,0,4}));
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;
        int pos = 0;
        for (int i=0; i<nums.length-1; i++) {
            pos = Math.max(pos, i+nums[i]);
            if (i == end) {
                jumps++;
                end = pos;
            }
        }
        return end == nums.length -1 ? jumps : -1;
    }
}
