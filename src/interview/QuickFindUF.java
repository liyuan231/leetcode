package interview;

public class QuickFindUF extends UnionFind {

    public QuickFindUF(int N) {
        super(N);
    }

    @Override
    public int find(int v) {
        return id[v];
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }


}
