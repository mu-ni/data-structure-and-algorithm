package algorithm.RecursionAndDP;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(36, 7));
        System.out.println(uniquePaths2(36, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }

    public static int uniquePaths2(int m, int n) {
        return dfs(m, n);
    }

    public static int dfs(int r, int c) {
        if(r == 1 || c == 1) {
            return 1;
        }

        return dfs(r-1, c) + dfs(r, c-1);
    }

}
