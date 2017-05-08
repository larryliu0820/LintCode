import java.util.Stack;

/**
 * Created by Valued Customer on 5/7/2017.
 * Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing all 1's and return its area.
 *
 * Example
 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 */
public class p436 {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        int max = 0;
        for (int row = 1; row < matrix.length; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int col = 0; col < matrix[0].length; col++) {
                dp[row][col] = dp[row-1][col] + matrix[row][col];
                if (stack.isEmpty()) {
                    stack.push(dp[row][col]);
                }
                
            }
        }


    }
}
