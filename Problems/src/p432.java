import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

/**
 * Created by Valued Customer on 12/10/2016.
 * 请找出有向图中弱联通分量的数目。图中的每个节点包含其邻居的 1 个标签和1 个列表。 （一个有向图中的相连节点指的是一个包含 2 个通过直接边沿路径相连的顶点的子图。）
 * 样例
 给定图:

 A----->B  C
 \     |  |
 \    |  |
 \   |  |
 \  v  v
 ->D  E <- F
 返回 {A,B,D}, {C,E,F}. 图中有 2 个相连要素，即{A,B,D} 和 {C,E,F} 。
 */
public class p432 {
    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    class UnionFind {
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
                fathers[rootA] = rootB;
            }
        }
    }
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        UnionFind uf = new UnionFind(nodes.size());
        for (DirectedGraphNode node : nodes) {
            if (uf.fathers[node.label] == node.label)   bfs(node, uf);
        }
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int i = 1; i < uf.fathers.length; i++) {
            int father = uf.fathers[i];
            if (!result.containsKey(father)) {
                // see if it connects to other root in the key set
                boolean newRoot = true;
                for (int k : result.keySet()) {
                    if (uf.query(k, father)) {
                        newRoot = false;
                        father = k;
                        break;
                    }
                }
                if (newRoot)
                    result.put(father, new HashSet<Integer>());
            }
            result.get(father).add(i);
        }
        List<List<Integer>> output = new ArrayList<>();
        for (int key : result.keySet()) {
            List<Integer> list = new ArrayList<>(result.get(key));
            output.add(list);
        }
        return output;
    }

    public void bfs(DirectedGraphNode node, UnionFind uf) {
        for (DirectedGraphNode n : node.neighbors) {
            if (n == node) continue;
            uf.connect(node.label, n.label);
            bfs(n, uf);
        }
    }
}
