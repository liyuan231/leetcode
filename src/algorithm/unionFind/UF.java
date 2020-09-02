package algorithm.unionFind;

/**
 * find(int id)时间复杂度为O(1)
 * union(int q,int p)时间复杂度为O(n)
 * 这里包含了两个算法：quick-union以及quick-find
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return quickFind(q) == quickFind(p);
    }

    public int quickFind(int q) {
        return id[q];
    }

    public void quickFindUnion(int p, int q) {
        int pID = quickFind(p);
        int qID = quickFind(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public int quickUnionFind(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void quickUnionUnion(int p, int q) {
        int pRoot = quickUnionFind(p);
        int qRoot = quickUnionFind(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int N = 10;
        int[][] nums = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {0, 4},
                {0, 5}, {0, 6}, {0, 7}, {0, 8},
                {0, 9}
        };
        UF uf = new UF(N);
        for (int[] num : nums) {
            if (uf.connected(num[0], num[1])) {
                continue;
            }
            uf.quickUnionUnion(num[0], num[1]);
        }
        int[] id = uf.id;
        for (int i = 0; i < id.length; i++) {
            System.out.println(i + ":" + id[i]);
        }

    }

}
