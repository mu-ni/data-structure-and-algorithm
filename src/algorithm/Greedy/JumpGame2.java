package algorithm.Greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame2().jump2(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame2().jump3(new int[]{2, 3, 1, 1, 4}));
    }

    public int jump(int[] nums) {
        int pos = 0;
        int max = 0;
        int step = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max, i + nums[i]);
            if (pos == i) {
                pos = max;
                step++;
            }
        }
        return pos >= nums.length - 1 ? step : -1;
    }

    public int jump2(int[] nums) {
        int pos = 0;
        int max = 0;
        int step = 0;
        // nums.length-1 !!!
        for (int i=0; i<nums.length-1; i++) {
            max = Math.max(max, i + nums[i]);
            if (pos == i) {
                pos = max;
                step++;
                if (pos >= nums.length-1) return step;
            }
        }
        return pos == 0 ? 0 : -1;
    }

    public int jump3(int[] nums) {
        if (nums.length <= 1) return 0;
        int pos = 0;
        int max = 0;
        int step = 0;
        for (int i=0; i<nums.length; i++) {
            max = Math.max(max, i+nums[i]);
            if (pos == i) {
                pos = max;
                step++;
                if (pos >= nums.length-1) return step;
            }
        }
        return -1;
    }
}
