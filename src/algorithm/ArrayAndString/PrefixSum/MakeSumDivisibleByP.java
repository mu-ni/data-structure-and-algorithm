package algorithm.ArrayAndString.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by muni on 2020/9/22
 */
public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        System.out.println(new MakeSumDivisibleByP().minSubarray(new int[]{3,1,4,2}, 6));
    }

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int rem = 0;
        for (int a : nums) {
            rem = (rem + a)%p;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        int rst = n;
        map.put(0, -1);
        for (int i=0; i<n; i++) {
            cur = (cur + nums[i])%p;
            map.put(cur, i);
            int need = (cur - rem + p)%p;
            if (map.containsKey(need)) rst = Math.min(rst, i-map.get(need));
        }
        return rst == n ? -1 : rst;
    }
}
