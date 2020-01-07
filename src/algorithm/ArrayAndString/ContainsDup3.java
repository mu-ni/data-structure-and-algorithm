package algorithm.ArrayAndString;

import java.util.TreeSet;

public class ContainsDup3 {
    public static void main(String[] args) {
        System.out.println(new ContainsDup3().containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3,0));
        System.out.println(new ContainsDup3().containsNearbyAlmostDuplicate2(new int[]{1,2,3,1}, 3,0));
    }

    // time limit exceeded
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<=i+k && j < nums.length; j++) {
                if (Math.abs((long)nums[i] - (long)nums[j]) <= (long)t) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            // successor
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // predecessor
            Integer p = set.floor(nums[i]);
            if (p != null && nums[i] <= p + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

//    // nums[i] and nums[j] <= t
//    // i and j <= k
//    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i=0; i<nums.length; i++) {
//            Integer ceiling = set.ceiling(nums[i]);
//            // new int[]{-1,2147483647}, 1,2147483647) integer overflow
//            if (ceiling != null && ceiling - nums[i] <= t) return true;
//            Integer floor = set.floor(nums[i]);
//            // new int[]{-1,2147483647}, 1,2147483647) integer overflow
//            if (floor != null && nums[i] - floor <= t) return true;
//            set.add(nums[i]);
//            if (set.size() > k) {
//                set.remove(nums[i-k]);
//            }
//        }
//        return false;
//    }
}
