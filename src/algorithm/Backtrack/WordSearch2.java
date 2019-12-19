package algorithm.Backtrack;

import algorithm.Tree.Dao.Trie;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(new WordSearch2().findWords(board, words));
        System.out.println(new WordSearch2().findWords2(board, words));
    }

    int m;
    int n;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        if (m == 0) return new ArrayList<>();
        n = board[0].length;

        Set<String> rst = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        Trie trie = buildTrie(words);
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dfs(rst, board, i, j, trie, "", visited);
            }
        }
        return new ArrayList<>(rst);
    }

    public void dfs(Set<String> rst, char[][] board, int x, int y, Trie trie, String path, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (visited[x][y]) return;

        path += board[x][y];
        if (!trie.startsWith(path)) return;
        if (trie.search(path)) {
            rst.add(path);
        }

        visited[x][y] = true;
        dfs(rst, board, x+1, y, trie, path, visited);
        dfs(rst, board, x-1, y, trie, path, visited);
        dfs(rst, board, x, y+1, trie, path, visited);
        dfs(rst, board, x, y-1, trie, path, visited);
        visited[x][y] = false;
    }

    public Trie buildTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords2(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> rst = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                backtrack(rst, board, i, j, trie, visited, "");
            }
        }
        return new ArrayList<>(rst);
    }

    public void backtrack(Set<String> rst, char[][] board, int x, int y, Trie trie, boolean[][] visited, String path) {
        if (trie.search(path)) {
            rst.add(path);
            return;
        }
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (visited[x][y] || !trie.startsWith(path)) return;
        visited[x][y] = true;
        path += board[x][y];
        for (int[] dir : dirs) {
            backtrack(rst, board, x + dir[0], y + dir[1], trie, visited, path);
        }
        visited[x][y] = false;
        path = path.substring(0, path.length()-1);
    }
}
