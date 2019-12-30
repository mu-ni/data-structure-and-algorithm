package algorithm.UnionFind;


import algorithm.UnionFind.Dao.UnionFind;

/**
 * Created by muni on 2019/12/30
 */
public class ConnectedComponentInGraph {
    public static void main(String[] args) {
        System.out.println(new ConnectedComponentInGraph().countComponents(5, new int[][]{{0,1},{1,2},{3,4}}));
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getCount();
    }
}