/**
 * Created by Valued Customer on 5/16/2017.
 *
 * Coins in a Line
 *
 * There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more
 * coins left. The player who take the last coin wins.

 Could you please decide the first play will win or lose?

 Example
 n = 1, return true.

 n = 2, return true.

 n = 3, return false.

 n = 4, return true.

 n = 5, return true.
 */
public class p394 {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n == 0) return false;
        if (n <= 2) return true;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        dp[1] = true;
        for (int i = 2; i < n; i++) {
            dp[i] = ! (dp[i-1] & dp[i-2]);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        p394 sol = new p394();
        System.out.println(sol.firstWillWin(3));
    }
}
