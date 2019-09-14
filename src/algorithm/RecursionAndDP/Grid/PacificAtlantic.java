package algorithm.RecursionAndDP.Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(new PacificAtlantic().pacificAtlantic(matrix));
        System.out.println(new PacificAtlantic().pacificAtlantic2(matrix));
    }

    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> rst = new ArrayList<>();
        m = matrix.length;
        if (m == 0) return rst;
        n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(pacific, matrix, Integer.MIN_VALUE, i, 0);
            dfs(atlantic, matrix, Integer.MIN_VALUE, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(pacific, matrix, Integer.MIN_VALUE, 0, j);
            dfs(atlantic, matrix, Integer.MIN_VALUE, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    rst.add(Arrays.asList(i, j));
                }
            }
        }
        return rst;
    }

    public void dfs(boolean[][] visited, int[][] matrix, int height, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (visited[x][y] || matrix[x][y] < height) return;

        visited[x][y] = true;
        dfs(visited, matrix, matrix[x][y], x - 1, y);
        dfs(visited, matrix, matrix[x][y], x + 1, y);
        dfs(visited, matrix, matrix[x][y], x, y - 1);
        dfs(visited, matrix, matrix[x][y], x, y + 1);
    }

    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> rst = new ArrayList<>();
        m = matrix.length;
        if (m == 0) return rst;
        n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isPacific(matrix, i, j) && isAtlantic(matrix, i, j)) {
                    rst.add(Arrays.asList(i, j));
                }
            }
        }
        return rst;
    }

    // TODO (1,4) ???
    public boolean isPacific(int[][] matrix, int x, int y) {
        // 0 ~ x, 0 ~ y
        boolean up = true;
        boolean left = true;
        int upMin = matrix[x][y];
        int leftMin = matrix[x][y];
        for (int i = x-1; i >=0; i--) {
            if (matrix[x][y] < matrix[i][y] || matrix[i][y] > leftMin) left = false;
            leftMin = matrix[i][y];
        }
        for (int j = y-1; j >= 0; j--) {
            if (matrix[x][y] < matrix[x][j] || matrix[x][j] > upMin) up = false;
            upMin = matrix[x][j];
        }
        return up || left;
    }

    public boolean isAtlantic(int[][] matrix, int x, int y) {
        // x ~ m, y ~ n
        boolean down = true;
        boolean right = true;
        int downMin = matrix[x][y];
        int rightMin = matrix[x][y];
        for (int i = x + 1; i < m; i++) {
            if (matrix[x][y] < matrix[i][y] || matrix[i][y] > rightMin) right = false;
            rightMin = matrix[i][y];
        }
        for (int j = y + 1; j < n; j++) {
            if (matrix[x][y] < matrix[x][j] || matrix[x][j] > downMin) down = false;
            downMin = matrix[x][j];
        }
        return down || right;
    }
}
