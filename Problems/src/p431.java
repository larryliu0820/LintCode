import java.util.*;

/**
 * Created by Valued Customer on 12/14/2016.
 * Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of
 * its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices
 * are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)
 *
 * Clarification
 Learn more about representation of graphs

 Example
 Given graph:

 A------B  C
 \     |  |
 \    |  |
 \   |  |
 \  |  |
 D   E
 Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

 */
public class p431 {
    Map<UndirectedGraphNode, Integer> lookupTable = new HashMap<>();
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        UnionFind uf = new UnionFind(nodes.size());
        boolean[] visited = new boolean[nodes.size()+1];
        int index = 1;
        for (UndirectedGraphNode node : nodes) {
            lookupTable.put(node,index++);
        }
        for (UndirectedGraphNode node : nodes) {
            int ind = lookupTable.get(node);
            if (!visited[ind])   bfs(node, uf, visited);
        }
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int i = 1; i < uf.fathers.length; i++) {
            int father = uf.fathers[i];
            if (!result.containsKey(father)) {
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

    public void bfs(UndirectedGraphNode node, UnionFind uf, boolean[] visited) {
        int ind1 = lookupTable.get(node);
        if (visited[ind1]) return;
        visited[ind1] = true;
        for (UndirectedGraphNode n : node.neighbors) {
            if (n == node) continue;
            int ind2 = lookupTable.get(n);
            uf.connect(ind1, ind2);
            bfs(n, uf, visited);
        }
    }
}
