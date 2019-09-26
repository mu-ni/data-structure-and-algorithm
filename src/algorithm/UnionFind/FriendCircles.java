package algorithm.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
    public static void main(String[] args) {
        int[][] M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new FriendCircles().findCircleNum(M));
    }

    int m;
    public int findCircleNum(int[][] M) {
        m = M.length;
        if (m == 0) return 0;
        boolean[] visited = new boolean[m];
        int count = 0;
        for (int i=0; i<m; i++) {
            if (visited[i]) continue;
            dfs(M, visited, i);
            count++;
        }
        return count;
    }

    // bfs mark visited as true so next loop will skip visited person
    // -> if (visited[i]) continue;
    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j=0; j<m; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
