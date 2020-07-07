package algorithm.SearchAndSort;

/**
 * Created by muni on 2020/7/7
 */
public class MinDaysMakeBouquets {
    public static void main(String[] args) {
        System.out.println(new MinDaysMakeBouquets().minDays(new int[]{1,10,3,10,2}, 3, 1));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m*k > bloomDay.length) return -1;
        int min = bloomDay[0];
        int max = bloomDay[0];
        for (int n : bloomDay) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        while (min <= max) {
            int mid = min + (max - min)/2;
            if (isValid(bloomDay, m, k, mid)) {
                if (mid == 0 || !isValid(bloomDay, m, k, mid-1)) return mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return -1;
    }

    private boolean isValid(int[] bloomDay, int m, int k, int d) {
        int[] arr = new int[bloomDay.length];
        for (int i=0; i<bloomDay.length; i++) {
            arr[i] = bloomDay[i] > d ? bloomDay[i] : -1;
        }
        int count = 0;
        int sum = 0;
        for (int n : arr) {
            if (n == -1) {
                sum++;
            } else {
                sum = 0;
            }
            if (sum == k) {
                count++;
                sum = 0;
            }
        }
        return count >= m;
    }
}
