package algorithm.Graph;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(matrix));
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        int max = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                boolean[][] visited = new boolean[m][n];
                int len = dfs(matrix, visited, i, j, Integer.MIN_VALUE, 0);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, boolean[][] visited, int x, int y, int val, int len) {
        if (x < 0 || y < 0 || x >= m || y >= n) return len;
        if (visited[x][y] || matrix[x][y] <= val) return len;

        visited[x][y] = true;
        int max = len;
        for (int[] dir : dirs) {
            max = Math.max(max, dfs(matrix, visited, x+dir[0], y+dir[1], matrix[x][y], len+1));
        }
        return max;
    }
}
