package algorithm.UnionFind;

public class NumOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new NumOfIslands().numIslands(grid));
        System.out.println(new NumOfIslands().numIslands2(grid));
    }

    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        int rst = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    rst++;
                }
            }
        }
        return rst;
    }

    public void dfs(char[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (grid[x][y] == '0' || visited[x][y]) return;

        visited[x][y] = true;
        dfs(grid, x+1, y, visited);
        dfs(grid, x-1, y, visited);
        dfs(grid, x, y+1, visited);
        dfs(grid, x, y-1, visited);
    }

    public int numIslands2(char[][] grid) {
        int count = 0;
        int m = grid.length;
        if (m == 0) return count;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if (grid[x][y] != '1') return;

        grid[x][y] = '0'; // visited
        dfs(grid, x+1, y);
        dfs(grid, x-1, y);
        dfs(grid, x, y+1);
        dfs(grid, x, y-1);
    }
}
