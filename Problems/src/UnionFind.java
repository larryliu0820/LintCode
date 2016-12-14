/**
 * Created by Valued Customer on 12/14/2016.
 */
public class UnionFind {
    int[] fathers;
    public UnionFind(int k) {
        fathers = new int[k+1];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
    }

    public int findRoot(int a) {
        if (fathers[a] == a) return a;
        fathers[a] = findRoot(fathers[a]);
        return fathers[a];
    }

    public boolean query(int a, int b) {
        return findRoot(a) == findRoot(b);
    }

    public void connect(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (rootA != rootB) {
            if (rootA < rootB)
                fathers[rootB] = rootA;
            else
                fathers[rootA] = rootB;
        }
    }

}
