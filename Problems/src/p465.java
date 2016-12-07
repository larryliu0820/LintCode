import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by larryliu on 12/4/16.
 * 给定两个排好序的数组 A, B，定义集合 sum = a + b ，求 sum 中第k小的元素
 * 样例
 给出 A = [1,7,11] B = [2,4,6]
 当 k = 3, 返回 7.

 当 k = 4, 返回 9.

 当 k = 8, 返回 15.


 */
public class p465 {
    int[] dx = new int[] {0, 1};
    int[] dy = new int[] {1, 0};

    public class Pair {
        public int x, y, sum;
        public Pair(int x, int y, int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.sum - o2.sum;
        }
    }

    // Check if a coordinate is valid and should be marked as visited
    public boolean isValid(int x, int y, int[] A, int[] B, boolean[][] visited) {
        if (x < A.length && y < B.length && !visited[x][y]) {
            return true;
        }
        return false;
    }

    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new PairComparator());
        pq.offer(new Pair(0, 0, A[0] + B[0]));

        boolean[][] visited = new boolean[A.length][B.length];

        for (int i = 0; i < k - 1; i++) {
            Pair smallest = pq.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = smallest.x + dx[j];
                int nextY = smallest.y + dy[j];

                if (isValid(nextX, nextY, A, B, visited)) {
                    visited[nextX][nextY] = true;
                    int nextSum = A[nextX] + B[nextY];
                    pq.offer(new Pair(nextX, nextY, nextSum));
                }
            }
        }
        return pq.peek().sum;
    }
}
