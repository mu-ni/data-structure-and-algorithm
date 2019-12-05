package algorithm.UnionFind;

import algorithm.UnionFind.Dao.UnionFind;

public class FriendCircles {
    public static void main(String[] args) {
        int[][] M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new FriendCircles().findCircleNum(M));
        M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new FriendCircles().findCircleNum2(M));
        M = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new FriendCircles().findCircleNum3(M));
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

    public int findCircleNum2(int[][] M) {
        m = M.length;
        if (m == 0) return 0;
        int count = 0;
        for (int i=0; i<m; i++) {
            if (M[i][i] == 1) {
                dfs(M, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int x) {
        for (int j=0; j<M.length; j++) {
            if (M[x][j] == 1) {
                M[x][j] = 0;
                M[j][x] = 0;
                dfs(M, j);
            }
        }
    }

    public int findCircleNum3(int[][] M) {
        int m = M.length;
        UnionFind uf = new UnionFind(m);
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}
