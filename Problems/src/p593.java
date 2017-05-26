/**
 * Created by Valued Customer on 5/21/2017.
 *
 * Stone Game II
 *
 * There is a stone game.At the beginning of the game the player picks n piles of stones in a circle.

 The goal is to merge the stones in one pile observing the following rules:

 At each step of the game,the player can merge two adjacent piles to a new pile.
 The score is the number of stones in the new pile.
 You are to determine the minimum of the total score.

 Example
 For [1, 4, 4, 1], in the best solution, the total score is 18:

 1. Merge second and third piles => [2, 4, 4], score +2
 2. Merge the first two piles => [6, 4]，score +6
 3. Merge the last two piles => [10], score +10
 Other two examples:
 [1, 1, 1, 1] return 8
 [4, 4, 5, 9] return 43

 */
public class p593 {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame2(int[] A) {
        // Write your code here
        // Write your code here
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[][] sum = new int[2*n][2*n];
        int[][] dp = new int[2*n][2*n];

        for (int i = 0; i < 2*n; i++) {
            sum[i][i] = A[i%n];
        }
        for (int len = 1; len < 2*n; len++) {
            for (int i = 0; i < 2*n - len; i++) {
                sum[i+len][i] = sum[i+len-1][i] + A[(i+len)%n];
            }
        }
        for (int len = 1; len < 2*n; len++) {
            for (int i = 0; i < 2*n - len; i++) {
                int min = Integer.MAX_VALUE;
                int k = i + len;
                for (int j = i; j < k; j++) {
                    min = Math.min(min, dp[j][i] + dp[k][j+1]);
                }
                dp[k][i] = min + sum[k][i];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i+n-1][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        p593 sol = new p593();
        int[] a = new int[]{1,1,4,4};
        System.out.println(sol.stoneGame2(a));
    }
}
