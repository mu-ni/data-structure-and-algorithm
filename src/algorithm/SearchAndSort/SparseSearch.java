package algorithm.SearchAndSort;

public class SparseSearch {
    public static void main(String[] args) {
        System.out.println(sparseSearch(new String[]{"at","","","","ball","","","car","","","dad","","",}, "ball"));
    }

    public static int sparseSearch(String[] strs, String target) {
        return sparseSearch(strs, 0, strs.length-1, target);
    }

    public static int sparseSearch(String[] strs, int left, int right, String target) {
        if (left > right) return -1;
        int mid = (left+right)/2;
        if  (strs[mid].equals(target)) return mid;

        int leftMid = mid;
        int rightMid = mid;
        if (strs[mid].isEmpty()) {
            leftMid--;
            rightMid--;
            while (strs[leftMid].isEmpty()) {
                leftMid--;
            }
            while (strs[rightMid].isEmpty()) {
                rightMid++;
            }
        }

        if (strs[leftMid].compareTo(target) >= 0) {
            return sparseSearch(strs, left, leftMid, target);
        }

        if (strs[rightMid].compareTo(target) <= 0) {
            return sparseSearch(strs, rightMid, right, target);
        }

        return -1;
    }
}
