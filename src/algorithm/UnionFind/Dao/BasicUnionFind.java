package algorithm.UnionFind.Dao;


/**
 * Created by muni on 2019/12/5
 */
public class BasicUnionFind {
    int count;
    int[] parent;

    public BasicUnionFind(int N) {
        count = N;
        parent = new int[N];
        for (int i=0; i<N; i++) {
            // connect to itself
            parent[i] = i;
        }
    }

    // O(n)
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        for (int i = 0; i< parent.length; i++) {
            if (find(i) == pId) {
                parent[i] = qId;
            }
        }
        count--;
    }

    // O(1)
    public int find(int p) {
        return parent[p];
    }

    public int getCount() {
        return this.count;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        BasicUnionFind uf = new BasicUnionFind(8);
        uf.union(2,3);
        uf.union(1,0);
        uf.union(0,4);
        uf.union(5,7);
        System.out.println(uf.getCount());
        System.out.println(uf.isConnected(1,2));
        System.out.println(uf.isConnected(1,4));
    }
}
