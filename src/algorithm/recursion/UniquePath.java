package algorithm.recursion;

public class UniquePath {
    public static void main(String[] args) {
        System.out.print(uniquePaths(4, 4));
    }

    public static int uniquePaths(int m, int n) {
        // write your code here
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

//    public static int uniquePaths(int m, int n) {
//        return dfs(m-1, n-1);
//    }
//    static int rst = 0;
//    public static int dfs(int r, int c) {
//        System.out.println(r + "," + c);
//        if(r == 0 && c == 0) {
//            rst++;
//        }
//        if(r > 0) {
//            dfs(r-1, c);
//        }
//        if(c > 0) {
//            dfs(r, c-1);
//        }
//        return rst;
//    }


}
