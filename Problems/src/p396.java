/**
 * Created by Valued Customer on 6/21/2017.
 * Coins in a Line III
 *
 * There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are
 * no more coins left. The player with the larger amount of money wins.

 Could you please decide the first player will win or lose?

 Example
 Given array A = [3,2,2], return true.

 Given array A = [1,2,4], return true.

 Given array A = [1,20,4], return false.

 */
public class p396 {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        if (n == 0) return false;
        if (n == 1) return true;
        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][i] = values[i];
                    sum[i][i] = values[i];
                }
                sum[i][j] = sum[i][j-1] + values[j];
            }

        for (int len = 1; len < n; len++) {
            for (int j = 0; j < n - len; j++) {
                int curr = Math.min(dp[j+1][j+len], dp[j][j+len-1]);
                dp[j][j+len] = sum[j][j+len] - curr;
            }
        }
        return dp[0][n-1] > sum[0][n-1] - dp[0][n-1];
    }
}
