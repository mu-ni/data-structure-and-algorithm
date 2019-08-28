package algorithm.RecursionAndDP.Grid;

public class UniquePath2 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePaths2(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

    public static int uniquePaths(int[][] obstacleGrid) { //2d
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    grid[i][j] = 0;
                    continue;
                }
                if(i==0 && j==0) {
                    grid[i][j] = 1;
                    continue;
                }
                if(i == 0) {
                    grid[i][j] = grid[i][j-1];
                    continue;
                }
                if(j == 0) {
                    grid[i][j] = grid[i-1][j];
                    continue;
                }
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[m-1][n-1];
    }

    public static int uniquePaths2(int[][] obstacleGrid) { //1d
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] grid = new int[n];
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    grid[j] = 0;
                    continue;
                }
                if(i==0 && j==0) {
                    grid[j] = 1;
                    continue;
                }
                if (j > 0) {
                    grid[j] += grid[j-1];
                }
            }
        }

        return grid[n-1];
    }
}
