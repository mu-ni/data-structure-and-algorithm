package algorithm.ArrayAndString;

public class OddCells {
    public static void main(String[] args) {
        System.out.println(new OddCells().oddCells(2,3, new int[][]{{0,1},{1,1}}));
        System.out.println(new OddCells().oddCells2(2,3, new int[][]{{0,1},{1,1}}));
    }

    public int oddCells(int n, int m, int[][] indices) {
        boolean[][] grid = new boolean[n][m];
        for (int[] pos : indices) {
            int x = pos[0];
            int y = pos[1];
            for (int i=0; i<n; i++) {
                grid[i][y] = !grid[i][y];
            }
            for (int j=0; j<m; j++) {
                grid[x][j] = !grid[x][j];
            }
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]) count++;
            }
        }
        return count;
    }

    public int oddCells2(int n, int m, int[][] indices) {
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        for (int[] pos : indices) {
            int x = pos[0];
            int y = pos[1];
            rows[x] ^= true; // ^ -> XOR
            cols[y] ^= true;
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (rows[i] ^ cols[j]) count++;
            }
        }
        return count;
    }
}
