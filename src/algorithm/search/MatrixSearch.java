package algorithm.search;

public class MatrixSearch {
    public static void main(String[] args) {
        System.out.print(matrixSearch(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 3));
    }

    public static boolean matrixSearch(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0;
        int col = matrix[0].length-1;
        while(row <= matrix.length-1 && col >=0) {
            if(matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col] > target) {
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
