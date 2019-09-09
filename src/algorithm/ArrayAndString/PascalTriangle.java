package algorithm.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(5));
        System.out.println(new PascalTriangle().generate2(5));
        System.out.println(new PascalTriangle().generate3(5));
    }

    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        for (int i=0; i< numRows; i++) {
            for (int j=0; j<=i; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] == 0 ? 1 : dp[i-1][j-1] + dp[i-1][j];
            }
        }

        List<List<Integer>> rst = new ArrayList<>();
        for (int i=0; i<dp.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                row.add(dp[i][j]);
            }
            rst.add(row);
        }
        return rst;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();
        for (int i=0; i< numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j == 0) {
                    row.add(1);
                    continue;
                }
                if (rst.get(i-1).size() <= j) {
                    row.add(1);
                    continue;
                }
                row.add(rst.get(i-1).get(j-1) + rst.get(i-1).get(j));
            }
            rst.add(row);
        }
        return rst;
    }

    public List<List<Integer>> generate3(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();
        for (int i=0; i< numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(rst.get(i-1).get(j-1) + rst.get(i-1).get(j));
            }
            rst.add(row);
        }
        return rst;
    }
}
