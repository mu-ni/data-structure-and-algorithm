package algorithm.recursion;

public class UniquePath2 {
    public static void main(String[] args) {
        System.out.print(uniquePaths(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

    public static int uniquePaths(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    if(i==0 && j==0) {
                        obstacleGrid[i][j] = 1;
                    } else if(i==0 && j >0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    } else if(i>0 && j==0) {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    } else {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                    }
                }
            }
        }

        return obstacleGrid[m-1][n-1];
    }
}
