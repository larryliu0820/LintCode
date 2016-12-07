/**
 * Created by larryliu on 12/2/16.
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

 You need to support the following method:
 1. connect(a, b), an edge to connect node a and node b
 2. query(), Returns the number of connected component in the graph
 Example
 5 // n = 5
 query() return 5
 connect(1, 2)
 query() return 4
 connect(2, 4)
 query() return 3
 connect(1, 4)
 query() return 3
 */
public class p591 {
    int[] father;
    int num;
    public p591(int n) {
        // initialize your data structure here.
        father = new int[n+1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
        num = n;
    }
    private int findRoot(int a) {
        if (a == father[a]) return a;
        father[a] = findRoot(father[a]);
        return father[a];
    }

    public void connect(int a, int b) {
        // Write your code here
        // Connect their root
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            num--;
        }
    }

    public int query() {
        // Write your code here
        return num;

    }
}
