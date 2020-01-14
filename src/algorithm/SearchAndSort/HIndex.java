package algorithm.SearchAndSort;

import java.util.Arrays;

/**
 * Created by muni on 2020/1/14
 */
public class HIndex {
    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3,0,6,1,5}));
        System.out.println(new HIndex().hIndex2(new int[]{3,0,6,1,5}));
        System.out.println(new HIndex().hIndex3(new int[]{3,0,6,1,5}));
        System.out.println(new HIndex().hIndex3(new int[]{0}));
    }

    // h papers have at least h citations each
    // citations[h] >= n-h
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        for (int c : citations) {
            count[Math.min(c, n)]++;
        }

        int sum = 0;
        for (int i=n; i>=0; i--) {
            sum += count[i];
            if (sum >= i) return i;
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int start = 0;
        int end = n-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (citations[mid] == n-mid) return n-mid;
            if (citations[mid] < n-mid) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return n - start;
    }

    public int hIndex3(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int start = 0;
        int end = n-1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (citations[mid] >= n-mid) {
                if (mid == 0 || citations[mid-1] < n-mid+1) return n - mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return 0;
    }
}
