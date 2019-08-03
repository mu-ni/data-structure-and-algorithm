package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.print(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        rst.add(new ArrayList<>());
        for(int n : nums) {
            int size = rst.size();
            for (int i=0; i< size; i++) {
                List<Integer> subset = new ArrayList<>();
                subset.addAll(rst.get(i));
                subset.add(n);
                rst.add(subset);
            }
        }
        return rst;
    }

//    // TODO
//    // recursion
//    static List<List<Integer>> rst = new ArrayList<>();
//    public static List<List<Integer>> subsets(int[] nums) {
//        if(nums.length == 0) return rst;
//        bfs(nums, 0, new ArrayList<>());
//        return rst;
//    }
//
//    public static void bfs(int[] nums, int index, List<Integer> each) {
//        rst.add(new ArrayList<>(each));
//        for(int i=index; i<nums.length; i++) {
//            each.add(nums[i]);
//            bfs(nums, i+1, each);
//            each.remove(each.size()-1);
//        }
//    }
}
