package algorithm.ArrayAndString;

public class thirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2,2,1,3}));
    }

    public static int thirdMax(int[] nums) {
        Integer l1 = null;
        Integer l2 = null;
        Integer l3 = null;
        for (int n : nums) {
            l1 = l1 == null ? n : Math.max(l1, n);
        }
        for (int n : nums) {
            if (n == l1) continue;
            l2 = l2 == null ? n : Math.max(l2, n);
        }
        for (int n : nums) {
            if (n == l1 || n == l2) continue;
            l3 = l3 == null ? n : Math.max(l3, n);
        }
        return l3 == null ? l1 : l3;
    }
}
