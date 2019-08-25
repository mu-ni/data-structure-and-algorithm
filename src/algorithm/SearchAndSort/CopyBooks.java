package algorithm.SearchAndSort;

public class CopyBooks {
    public static void main(String[] args) {
        System.out.println(copyBooks(new int[]{3,2,4}, 2));
    }

    public static int copyBooks(int[] pages, int k) {
        return backtrack(pages, 0, k);
    }

    public static int backtrack(int[] arr, int start, int end) {
        return 0;
    }
}
