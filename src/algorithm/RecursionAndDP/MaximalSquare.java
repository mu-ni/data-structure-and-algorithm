package algorithm.RecursionAndDP;

public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare obj = new MaximalSquare();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        System.out.println(obj.isSquare(matrix, 0, 0, 1));
//        System.out.println(obj.isSquare(matrix, 1, 2, 1));
        System.out.println(obj.maximalSquare(matrix));
    }

    int max = 0;
    public int maximalSquare(char[][] matrix) { // return max area
        dfs(0, matrix);
        return max;
    }

    public void dfs(int row, char[][] matrix) {
        if (row == matrix.length-1) {
            return;
        }
        for (int col=0; col<matrix.length; col++) {
            if (matrix[row][col] != '1') continue;
            loop:
            for (int i = 1; col + i<matrix.length; i++) {
                if (!isSquare(matrix, row, col, i)) {
                    break loop;
                }
                max = Math.max(max, (i+1)*(i+1));
            }
            dfs(row+1, matrix);
        }
    }

    public boolean isSquare(char[][] matrix, int x, int y, int len) {
        for (int i=0; i<=len; i++) {
            for(int j=0; j<=len; j++) {
                if(matrix[x+i][y+j] != '1') return false;
            }
        }
        return true;
    }
}
