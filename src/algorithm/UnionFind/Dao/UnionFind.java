package algorithm.UnionFind.Dao;

/**
 * Created by muni on 2019/12/5
 */
public class UnionFind {
    int count;
    int[] parent;

    public UnionFind(int N) {
        count = N;
        parent = new int[N];
        for (int i=0; i<N; i++) {
            // connect to itself
            parent[i] = i;
        }
    }

    // O(1)
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootQ] = rootP;
        count--;
    }

    // O(n)
    public int find(int p) {
        while (p != parent[p]) {
            // reduce path length
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(8);
        uf.union(2,3);
        uf.union(1,0);
        uf.union(0,4);
        uf.union(5,7);
        System.out.println(uf.getCount());
        System.out.println(uf.isConnected(1,2));
        System.out.println(uf.isConnected(1,4));
    }
}
