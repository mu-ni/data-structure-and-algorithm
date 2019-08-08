package algorithm.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}})));
    }

    public static int[][] setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(matrix[i][j] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }

        for(List<Integer> list : lists) {
            setZero(matrix, list.get(0), list.get(1));
        }

        return matrix;
    }

    public static void setZero(int[][] matrix, int a, int b) {
        for(int i=0; i<matrix.length; i++) {
            matrix[i][b] = 0;
        }
        for(int i=0; i<matrix[0].length; i++) {
            matrix[a][i] = 0;
        }
    }
}