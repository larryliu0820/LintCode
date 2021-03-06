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


    Map<DirectedGraphNode, Integer> lookupTable = new HashMap<>();
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        UnionFind uf = new UnionFind(nodes.size());
        boolean[] visited = new boolean[nodes.size()+1];
        int index = 1;
        for (DirectedGraphNode node : nodes) {
            lookupTable.put(node,index++);
        }
        for (DirectedGraphNode node : nodes) {
            int ind = lookupTable.get(node);
            if (!visited[ind])   bfs(node, uf, visited);
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
            result.get(father).add(nodes.get(i-1).label);
        }
        List<List<Integer>> output = new ArrayList<>();
        for (int key : result.keySet()) {

            List<Integer> list = new ArrayList<>(result.get(key));
            Collections.sort(list);
            output.add(list);
        }
        return output;
    }

    public void bfs(DirectedGraphNode node, UnionFind uf, boolean[] visited) {
        int ind1 = lookupTable.get(node);
        if (visited[ind1]) return;
        visited[ind1] = true;
        for (DirectedGraphNode n : node.neighbors) {
            if (n == node) continue;
            int ind2 = lookupTable.get(n);
            uf.connect(ind1, ind2);
            bfs(n, uf, visited);
        }
    }
}
