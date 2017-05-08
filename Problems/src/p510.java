import java.util.Stack;

/**
 * Created by Valued Customer on 4/1/2017.
 *
 * Maximal Rectangle
 *
 * Given a 2D boolean matrix filled with False and True, find the largest rectangle containing all True and return its area.
 *
 * Example
 Given a matrix:

 [
 [1, 1, 0, 0, 1],
 [0, 1, 0, 0, 1],
 [0, 0, 1, 1, 1],
 [0, 0, 1, 1, 1],
 [0, 0, 0, 0, 1]
 ]
 return 6.

 */
public class p510 {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null) return 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    height[i][j] = matrix[i][j] ? 1 : 0;
                else
                    height[i][j] = matrix[i][j] ? height[i-1][j] + 1 : 0;
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                while (!stack.isEmpty() && height[i][j] < height[i][stack.peek()]) {
                    int pos = stack.pop();
                    answer = Math.max(answer, height[i][pos] * (stack.isEmpty()? j : j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int pos = stack.pop();
                answer = Math.max(answer, height[i][pos] * (stack.isEmpty()? m : m - stack.peek() - 1));
            }
        }
        return answer;

    }
}
