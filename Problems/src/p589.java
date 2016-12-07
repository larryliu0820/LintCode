/**
 * Created by larryliu on 12/2/16.
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

 You need to support the following method:
 1. connect(a, b), add an edge to connect node a and node b.
 2. query(a, b), check if two nodes are connected
 Example:
 5 // n = 5
 query(1, 2) return false
 connect(1, 2)
 query(1, 3) return false
 connect(2, 4)
 query(1, 4) return true
 */
public class p589 {
    int[] father;
    public p589(int n) {
        // initialize your data structure here.
        father = new int[n+1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }
    private int findRoot(int a) {
        if (a == father[a]) return a;
        return findRoot(father[a]);
    }

    public void connect(int a, int b) {
        // Write your code here
        // Connect their root
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
        }
    }

    public boolean  query(int a, int b) {
        // Write your code here
        return findRoot(a) == findRoot(b);
    }
}
