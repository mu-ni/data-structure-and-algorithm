package algorithm.ArrayAndString.Matrix;

import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix2(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        while(true) {
            for (int i=left; i<=right; i++) {
                matrix[top][i] = num;
                num++;
            }
            top++;
            if (top > bottom || left > right) break;

            for (int i=top; i<=bottom; i++) {
                matrix[i][right] = num;
                num++;
            }
            right--;
            if (top > bottom || left > right) break;

            for (int i=right; i>=left; i--) {
                matrix[bottom][i] = num;
                num++;
            }
            bottom--;
            if (top > bottom || left > right) break;

            for (int i=bottom; i>=top; i--) {
                matrix[i][left] = num;
                num++;
            }
            left++;
            if (top > bottom || left > right) break;
        }

        return matrix;
    }

    public static int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        while(top <= bottom && left <= right) { // n x n
            for (int i=left; i<=right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i=top; i<=bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            for (int i=right; i>=left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            for (int i=bottom; i>=top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}
