/**
 * Created by Valued Customer on 5/16/2017.
 *
 * Coins in a Line II
 *
 * There are n coins with different value in a line. Two players take turns to take one or two coins from left side until
 * there are no more coins left. The player who take the coins with the most value wins.

 Could you please decide the first player will win or lose?

 Example
 Given values array A = [1,2,2], return true.

 Given A = [1,2,4], return false.

 */
public class p395 {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) return false;
        int len = values.length;
        if (len <= 2) return true;

        int[] dp = new int[values.length+1];
        dp[len] = 0;
        dp[len-1] = values[len-1];
        dp[len-2] = values[len-1] + values[len-2];
        dp[len-3] = values[len-3] + values[len-2];
        for (int i = len-4; i >= 0; i--) {
            int takeOne = values[i] + Math.min(dp[i+2], dp[i+3]);
            int takeTwo = values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]);
            dp[i] = Math.max(takeOne, takeTwo);
        }
        int sum = 0;
        for (int v : values) sum += v;
        return dp[0] > sum / 2;
    }

    public static void main(String[] args) {
        p395 sol = new p395();
        System.out.println(sol.firstWillWin(new int[]{100,200,400,300,400,800,500,600,1200}));
    }
}
