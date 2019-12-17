package algorithm.Backtrack;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new WordSearch().exist(board, "ABCCED"));
        System.out.println(new WordSearch().exist2(board, "ABCCED"));
        System.out.println(new WordSearch().exist3(new char[][]{{'a'}}, "a"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int x, int y, String word, int i) {
        if (i == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (board[x][y] != word.charAt(i)) return false;

        char c = board[x][y];
        board[x][y] = '#';
        boolean exist = backtrack(board, x - 1, y, word, i + 1)
                || backtrack(board, x + 1, y, word, i + 1)
                || backtrack(board, x, y - 1, word, i + 1)
                || backtrack(board, x, y + 1, word, i + 1);
        board[x][y] = c;

        return exist;
    }

    public boolean exist2(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int x, int y, String word, int i, boolean[][] visited) {
        if (i == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        if (word.charAt(i) != board[x][y] || visited[x][y]) return false;

        visited[x][y] = true;
        boolean exist = backtrack(board, x - 1, y, word, i + 1, visited)
                || backtrack(board, x + 1, y, word, i + 1, visited)
                || backtrack(board, x, y - 1, word, i + 1, visited)
                || backtrack(board, x, y + 1, word, i + 1, visited);
        visited[x][y] = false;
        return exist;
    }

    int m;
    int n;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist3(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (dfs(board, i, j, 0, word, visited)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, int index, String word, boolean[][] visited) {
        if (index == word.length()) return true;
        if (x < 0 || y < 0 || x >= m || y >= n) return false;
        if (board[x][y] != word.charAt(index) || visited[x][y]) return false;
        visited[x][y] = true;
        boolean found = false;
        for (int[] dir : dirs) {
            found = found || dfs(board, x+dir[0], y+dir[1], index+1, word, visited);
        }
        visited[x][y] = false;
        return found;
    }
}
