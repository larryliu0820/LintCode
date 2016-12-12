import java.util.*;

/**
 * Created by Valued Customer on 12/7/2016.
 * 给出 n 个节点，标号分别从 0 到 n - 1 并且给出一个 无向 边的列表 (给出每条边的两个顶点), 写一个函数去判断这张｀无向｀图是否是一棵树

 注意事项

 你可以假设我们不会给出重复的边在边的列表当中. 无向边　[0, 1] 和 [1, 0]　是同一条边， 因此他们不会同时出现在我们给你的边的列表当中。

 样例
 给出n = 5 并且 edges = [[0, 1], [0, 2], [0, 3], [1, 4]], 返回 true.

 给出n = 5 并且 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], 返回 false.
 */
public class p178 {

    public class UnionFind {
        public int[] fathers;
        public int num;
        public UnionFind(int n) {
            fathers = new int[n];
            num = n;
            for (int i = 0; i < n; i++) {
                fathers[i] = i;
            }
        }

        private int findRoot(int a) {
            if (fathers[a] == a) return a;
            fathers[a] = findRoot(fathers[a]);
            return fathers[a];
        }
        public boolean query(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            return rootA == rootB;
        }

        public void connect(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (rootA != rootB) {
                fathers[rootA] = rootB;
                num--;
            }
        }
    }

    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        // do a bfs
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (uf.query(edge[0], edge[1])) return false;
            uf.connect(edge[0], edge[1]);
        }
        return uf.num == 1;
    }

    public static void main(String[] args) {
        p178 sol = new p178();
        int[][] edges = new int[][]{
                {0,1},
                {1,2},
                {3,2},
                {4,3},
                {4,5},
                {5,6},
                {6,7}
        };
        System.out.println(sol.validTree(8,edges));
    }
}
