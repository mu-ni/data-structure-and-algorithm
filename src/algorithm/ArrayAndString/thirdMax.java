package algorithm.ArrayAndString;

public class thirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2,2,1,3}));
        System.out.println(thirdMax2(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1}));
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

    public static int thirdMax2(int[] nums) {
        Integer l1 = null;
        Integer l2 = null;
        Integer l3 = null;
        for (Integer n : nums) {
            if (n.equals(l1) || n.equals(l2) || n.equals(l3)) continue;
            if (l1 == null || n > l1) {
                l3 = l2;
                l2 = l1;
                l1 = n;
                continue;
            }
            if (l2 == null || n > l2) {
                l3 = l2;
                l2 = n;
                continue;
            }
            if (l3 == null || n > l3) {
                l3 = n;
            }
        }
        return l3 == null ? l1 : l3;
    }
}
