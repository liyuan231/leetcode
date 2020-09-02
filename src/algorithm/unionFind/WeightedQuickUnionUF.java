package algorithm.unionFind;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        /**
         * 优先归并到小树
         */
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;

    }

    public static void main(String[] args) {
        int N = 10;
        int[][] nums = new int[][]{
                {4,3},{3,8},{6,5},{9,4},
                {2,1},{8,9},{5,0},{7,2},
                {6,1},{1,0},{6,7}
        };
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        for (int[] num : nums) {
            if (uf.connected(num[0], num[1])) {
                continue;
            }
            uf.union(num[0], num[1]);
        }
        int[] id = uf.id;
        for (int i = 0; i < id.length; i++) {
            System.out.println(i + ":" + id[i]);
        }

    }
}
