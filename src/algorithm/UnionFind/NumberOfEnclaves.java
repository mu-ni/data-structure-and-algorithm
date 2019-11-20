package algorithm.UnionFind;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] A = new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(new NumberOfEnclaves().numEnclaves(A));
    }

    // return number of land squares
    int m;
    int n;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numEnclaves(int[][] A) {
        m = A.length;
        n = A[0].length;

        for (int i=0; i<m; i++) {
            if (A[i][0] == 1) dfs(A, i, 0);
            if (A[i][n-1] == 1) dfs(A, i, n-1);
        }
        for (int j=0; j<n; j++) {
            if (A[0][j] == 1) dfs(A, 0, j);
            if (A[m-1][j] == 1) dfs(A, m-1, j);
        }

        int squares = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (A[i][j] == 0) continue;
                squares += dfs(A, i, j);
            }
        }
        return squares;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) return 0;
        if (grid[x][y] == 0) return 0;
        grid[x][y] = 0;

        int count = 1;
        for (int[] dir : dirs) {
            count += dfs(grid, x + dir[0], y + dir[1]);
        }
        return count;
    }
}
