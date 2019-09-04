package algorithm.ArrayAndString;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(rotate2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(rotate3(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}})));
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
        return matrix;
    }

    public static int[][] rotate2(int[][] matrix) {
        int n = matrix.length;
        // transpose
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // swap col
        for (int i=0; i< n; i++) {
            for (int j=0; j<n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
        return matrix;
    }

    public static int[][] rotate3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rst = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rst[j][i] = matrix[m - 1 - i][j];
            }
        }
        return rst;
    }
}
