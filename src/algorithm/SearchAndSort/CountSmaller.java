package algorithm.SearchAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmaller {
    public static void main(String[] args) {
        System.out.println(new CountSmaller().countSmaller(new int[]{5,2,6,1}));
        System.out.println(new CountSmaller().countSmaller2(new int[]{5,2,6,1}));
    }

    // brute force
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int count = 0;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }
            rst.add(count);
        }
        return rst;
    }

    public List<Integer> countSmaller2(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for(int i = nums.length-1 ; i >= 0 ; i--) {
            int index = getIndex(sorted , nums[i]);
            res[i] = index;
            sorted.add(index , nums[i]);
        }
        return Arrays.asList(res);
    }

    private int getIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size()-1;
        if (target <= sorted.get(start)) return start;
        if (target > sorted.get(end)) return end + 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(sorted.get(mid) < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}
