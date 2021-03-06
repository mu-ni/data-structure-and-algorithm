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
        System.out.println(new WordSearch2().findWords3(board, words));
        board = new char[][]{{'a', 'b'},{'a', 'a'}};
        words = new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        System.out.println(new WordSearch2().findWords(board, words));
        System.out.println(new WordSearch2().findWords2(board, words));
        System.out.println(new WordSearch2().findWords3(board, words));
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
        }
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (visited[x][y] || !trie.startsWith(path)) return;
        visited[x][y] = true;
        for (int[] dir : dirs) {
            backtrack(rst, board, x + dir[0], y + dir[1], trie, visited, path + board[x][y]);
        }
        visited[x][y] = false;
    }

    public List<String> findWords3(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> set = new HashSet<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                backtrack(set, trie, board, i, j, "");
            }
        }
        return new ArrayList<>(set);
    }

    public void backtrack(Set<String> set, Trie trie, char[][] board, int x, int y, String path) {
        if (trie.search(path)) {
            set.add(path);
        }
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        if (!trie.startsWith(path) || board[x][y] == '#') return;
        char tmp = board[x][y];
        board[x][y] = '#';
        for (int[] dir : dirs) {
            backtrack(set, trie, board, x+dir[0], y + dir[1], path + tmp);
        }
        board[x][y] = tmp;
    }
}
