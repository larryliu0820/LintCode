import java.util.PriorityQueue;

/**
 * Created by larryliu on 12/3/16.
 * 在一个排序矩阵中找从小到大的第 k 个整数。

 排序矩阵的定义为：每一行递增，每一列也递增。

 样例
 给出 k = 4 和一个排序矩阵：

 [
 [1 ,5 ,7],
 [3 ,7 ,8],
 [4 ,8 ,9],
 ]
 返回 5。

 */
public class p401 {

    public class Node {
        public int value;
        public int col;
        public int row;
        public Node(int value, int row, int col) {
            this.value = value;
            this.col = col;
            this.row = row;
        }
    }
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> b.value - a.value);
        for (int i = 0; i < matrix[0].length; i++) {
            pq.offer(new Node(matrix[i][0], 0, i));
        }
        for (int i = 0; i < k; i++) {
            Node rootNode = pq.poll();
            pq.offer(new Node(matrix[rootNode.col+1][rootNode.row], rootNode.row, rootNode.col+1));
        }
        return pq.peek().value;
    }
}
