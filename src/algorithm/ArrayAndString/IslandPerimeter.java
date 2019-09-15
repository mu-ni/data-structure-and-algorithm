package algorithm.ArrayAndString;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int rst = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) continue;
                rst += 4;
                if (i != 0 && grid[i-1][j] == 1) {
                    rst -= 2;
                }
                if (j != 0 && grid[i][j-1] == 1) {
                    rst -= 2;
                }
            }
        }
        return rst;
    }
}
