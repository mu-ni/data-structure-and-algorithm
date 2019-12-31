package algorithm.SetAndMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muni on 2019/12/31
 */
public class LongestContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(new LongestContinuousSubarray().longestSubarray(new int[]{1,3,4,2,6,5,9,7,3}));
    }

    // 找到全部最长的连续偶数或者奇数，输出list集合
    // longest continuous odd or even subarray
    public List<Integer> longestSubarray(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if (list.size() == 0 || n%2 == 0 && list.get(list.size()-1)%2 == 0 || n%2 == 1 && list.get(list.size()-1)%2 == 1) {
                list.add(n);
            } else {
                if (list.size() > rst.size()) rst = list;
                list = new ArrayList<>();
                list.add(n);
            }
        }
        if (list.size() > rst.size()) rst = list;
        return rst;
    }
}
