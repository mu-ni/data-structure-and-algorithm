package algorithm.RecursionAndDP.Grid;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(36, 7));
        System.out.println(uniquePaths1(36, 7));
        System.out.println(uniquePaths2(36, 7));
        System.out.println(uniquePaths3(36, 7));
        System.out.println(uniquePaths4(36, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
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

    public static int uniquePaths1(int m, int n) { //2d
        int[][] grid = new int[m][n];
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || j == 0) {
                    grid[i][j] = 1;
                    continue;
                }
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }

    public static int uniquePaths2(int m, int n) { //1d
        int[] grid = new int[n];
        for(int i=0; i< m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 || j == 0) {
                    grid[j] = 1;
                    continue;
                }
                grid[j] += grid[j-1];
            }
        }
        return grid[n-1];
    }

    public static int uniquePaths3(int r, int c) {
        if(r == 1 || c == 1) {
            return 1;
        }

        return uniquePaths3(r-1, c) + uniquePaths3(r, c-1);
    }

    public static int uniquePaths4(int m, int n) {
        return dfs(m,n);
    }

    static int rst = 0;
    public static int dfs(int x, int y) {
        if (x == 1 && y == 1) {
            rst++;
        }
        if (x >1) {
            dfs(x-1, y);
        }
        if (y >1) {
            dfs(x, y-1);
        }
        return rst;
    }

}
