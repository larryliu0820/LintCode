/**
 * Created by Valued Customer on 6/30/2017.
 * Sliding Window Matrix Maximum
 *
 * Given an array of n * m matrix, and a moving matrix window (size k * k), move the window from top left to botton
 * right at each iteration, find the maximum sum inside the window at each moving.
 Return 0 if the answer does not exist.

 Example
 For matrix

 [
 [1, 5, 3],
 [3, 2, 1],
 [4, 1, 9],
 ]
 The moving window size k = 2.
 return 13.

 At first the window is at the start of the array like this

 [
 [|1, 5|, 3],
 [|3, 2|, 1],
 [4, 1, 9],
 ]
 ,get the sum 11;
 then the window move one step forward.

 [
 [1, |5, 3|],
 [3, |2, 1|],
 [4, 1, 9],
 ]
 ,get the sum 11;
 then the window move one step forward again.

 [
 [1, 5, 3],
 [|3, 2|, 1],
 [|4, 1|, 9],
 ]
 ,get the sum 10;
 then the window move one step forward again.

 [
 [1, 5, 3],
 [3, |2, 1|],
 [4, |1, 9|],
 ]
 ,get the sum 13;
 SO finally, get the maximum from all the sum which is 13.
 */
public class p558 {
    /**
     * @param matrix an integer array of n * m matrix
     * @param k an integer
     * @return the maximum number
     */
    public int maxSlidingMatrix(int[][] matrix, int k) {
        // Write your code here
        if (matrix == null) return 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] sum = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] + matrix[i-1][j-1] - sum[i-1][j-1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        for (int ycor = 0; ycor+k <= n; ycor++) {
            for (int xcor = 0; xcor+k <= m; xcor++) {
                int currSum = sum[ycor+k][xcor+k] - sum[ycor+k][xcor] -
                        (sum[ycor][xcor+k] - sum[ycor][xcor]);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}
