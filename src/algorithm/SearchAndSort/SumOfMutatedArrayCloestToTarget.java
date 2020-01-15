package algorithm.SearchAndSort;

/**
 * Created by muni on 2020/1/15
 */
public class SumOfMutatedArrayCloestToTarget {
    public static void main(String[] args) {
        System.out.println(new SumOfMutatedArrayCloestToTarget().findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
    }

    public int findBestValue(int[] arr, int target) {
        int max = 0;
        for (int n : arr) {
            max = Math.max(max, n);
        }

        int start = 0;
        int end = max;
        int rst = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int sum = countSum(arr, mid);
            if (sum == target) return mid;
            if (Math.abs(sum-target) < diff) {
                diff = Math.abs(sum-target);
                rst = mid;
            } else if (Math.abs(sum-target) == diff) {
                rst = Math.min(rst, mid);
            }
            if (sum > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return rst;
    }

    private int countSum(int[] arr, int bar) {
        int sum = 0;
        for (int n : arr) {
            sum += Math.min(n, bar);
        }
        return sum;
    }
}
