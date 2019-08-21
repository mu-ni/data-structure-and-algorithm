package algorithm.RecursionAndDP;

public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare obj = new MaximalSquare();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(obj.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) { // return max area
        if (matrix.length == 0) return 0;
        int max = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] != '1') continue;
                max = Math.max(max, 1);
                loop:
                for (int l = 1; l+i<matrix.length && l+j<matrix[0].length; l++) {
                    if (!isSquare(matrix,i,j,l)) {
                        break loop;
                    }
                    max = Math.max(max, (l+1)*(l+1));
                }
            }
        }
        return max;
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
