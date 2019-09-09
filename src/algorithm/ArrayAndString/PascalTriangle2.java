package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        System.out.println(new PascalTriangle2().getRow(5));
        System.out.println(new PascalTriangle2().getRow2(5));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == 0 || i == j) {
                    rst.add(1);
                    continue;
                }
                if (j == 0) {
                    continue;
                }
                rst.set(j, rst.get(j) + rst.get(j - 1));
            }
        }
        return rst;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> rst = new ArrayList<>();
        rst.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                rst.set(j, rst.get(j) + rst.get(j - 1));
            }
            rst.add(1);
        }
        return rst;
    }
}
