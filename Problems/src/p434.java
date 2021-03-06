import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valued Customer on 12/15/2016.
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
 * Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
 * The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island.
 * Return how many island are there in the matrix after each operator.

 Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].

 return [1,1,2,2].
 */
public class p434 {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(n * m + 1);
        boolean[] visited = new boolean[n * m + 1];
        int count = 0;
        for (Point p : operators) {
            int value = (p.x * m) + p.y + 1;
            if (visited[value]) continue;
            else visited[value] = true;
            count++;
            if (value % m != 1 && visited[value-1]) {
                if (!uf.query(value, value - 1))  {
                    uf.connect(value, value - 1);
                    count--;
                }
            }
            if (value % m != 0 && visited[value+1]) {
                if (!uf.query(value, value + 1))  {
                    uf.connect(value, value + 1);
                    count--;
                }
            }
            if (value > m && visited[value - m]) {
                if (!uf.query(value, value - m))  {
                    uf.connect(value, value - m);
                    count--;
                }
            }
            if (value <= (n - 1) * m && visited[value + m]) {
                if (!uf.query(value, value + m))  {
                    uf.connect(value, value + m);
                    count--;
                }
            }
            int temp = count;
            result.add(temp);
        }
        return result;
    }
}
