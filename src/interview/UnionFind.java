package interview;

public abstract class UnionFind {
    protected int[] id;

    public UnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int v);

    public abstract void union(int p, int q);

}
