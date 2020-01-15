package algorithm.SearchAndSort;

/**
 * Created by muni on 2020/1/15
 */
public class CapacityToShipPackage {
    public static void main(String[] args) {
        System.out.println(new CapacityToShipPackage().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }

    public int shipWithinDays(int[] weights, int D) {
        int max = 0;
        int sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        int start = max;
        int end = sum;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (countDay(weights, mid) > D) {
                start = mid+1;
            } else {
                if (mid == max || countDay(weights, mid-1) > D) return mid;
                end = mid-1;
            }
        }
        return -1;
    }

    private int countDay(int[] weights, int cap) {
        int count = 1;
        int sum = 0;
        for (int w : weights) {
            if (sum + w > cap) {
                count++;
                sum = w;
            } else {
                sum += w;
            }
        }
        return count;
    }
}
