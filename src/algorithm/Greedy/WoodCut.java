package algorithm.Greedy;

public class WoodCut {
    public static void main(String[] args) {
        System.out.println(new WoodCut().woodCut(new int[]{232, 124, 456}, 7));
    }

    public int woodCut(int[] L, int k) {
        if (L.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int l : L) {
            max = Math.max(max, l);
        }

        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (isValid(L, k, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isValid(L, k, start)) return start;
        if (isValid(L, k, end)) return end;
        return 0;
    }

    public boolean isValid(int[] L, int k, int len) {
        int count = 0;
        for (int l : L) {
            count += l/len;
        }
        return count >= k;
    }
}
