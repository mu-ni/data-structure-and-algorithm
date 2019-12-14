package algorithm.SearchAndSort;

public class WoodCut {
    public static void main(String[] args) {
        System.out.println(new WoodCut().woodCut(new int[]{232, 124, 456}, 7));
        System.out.println(new WoodCut().woodCut2(new int[]{232, 124, 456}, 7));
    }

    // At least k pieces of wood, as long as possible
    // what is the longest length of each piece of wood?
    public int woodCut(int[] L, int k) {
        if (L.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int l : L) {
            max = Math.max(max, l);
            sum += l;
        }
        if (sum < k) return 0;

        int start = 1; // shortest cut length
        int end = max; // longest cut length
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(L, k, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    public boolean isValid(int[] L, int k, int len) {
        int count = 0;
        for (int l : L) {
            count += l / len;
        }
        return count >= k;
    }

    public int woodCut2(int[] L, int k) {
        if (L.length == 0) return 0;
        int max = L[0];
        for (int l : L) {
            max = Math.max(max, l);
        }
        if (k == 1) return max;

        int start = 1;
        int end = max;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isValid(L, k, mid)) {
                if (mid == max || !isValid(L, k, mid+1)) return mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
