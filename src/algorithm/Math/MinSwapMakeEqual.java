package algorithm.Math;

public class MinSwapMakeEqual {
    public static void main(String[] args) {
        System.out.println(new MinSwapMakeEqual().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }

    public int minimumSwap(String s1, String s2) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (s1.charAt(i) == 'x') {
                x1++;
            } else {
                y1++;
            }
            if (s2.charAt(i) == 'x') {
                x2++;
            } else {
                y2++;
            }
        }
        if ((x1+x2)%2 != 0 || (y1+y2)%2 != 0) return -1;

        return x1/2 + y1/2 + x1%2 + y1%2;
    }
}
