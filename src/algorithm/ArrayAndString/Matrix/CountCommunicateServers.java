package algorithm.ArrayAndString.Matrix;

/**
 * Created by muni on 2019/12/27
 */
public class CountCommunicateServers {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,0,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,1}
        };
        System.out.println(new CountCommunicateServers().countServers(grid));
        System.out.println(new CountCommunicateServers().countServers2(grid));
    }

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int sum = 0;
        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) sum++;
                if (rows[i] == 1 && cols[j] == 1 && grid[i][j] == 1) count++;
            }
        }
        return sum - count;
    }

    public int countServers2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int count = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ((rows[i] > 1 || cols[j] > 1) && grid[i][j] == 1) count++;
            }
        }
        return count;
    }
}
