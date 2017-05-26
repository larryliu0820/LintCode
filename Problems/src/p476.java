/**
 * Created by Valued Customer on 5/22/2017.
 *
 * Stone Game
 *
 * There is a stone game.At the beginning of the game the player picks n piles of stones in a line.

 The goal is to merge the stones in one pile observing the following rules:

 At each step of the game,the player can merge two adjacent piles to a new pile.
 The score is the number of stones in the new pile.
 You are to determine the minimum of the total score.

 Example
 For [4, 1, 1, 4], in the best solution, the total score is 18:

 1. Merge second and third piles => [4, 2, 4], score +2
 2. Merge the first two piles => [6, 4]，score +6
 3. Merge the last two piles => [10], score +10
 Other two examples:
 [1, 1, 1, 1] return 8
 [4, 4, 5, 9] return 43

 */
public class p476 {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) return 0;
        int[][] sum = new int[A.length][A.length];
        int[][] dp = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            sum[i][i] = A[i];
        }
        for (int len = 1; len < A.length; len++) {
            for (int i = 0; i < A.length - len; i++) {
                sum[i+len][i] = sum[i+len-1][i] + A[i+len];
            }
        }
        for (int len = 1; len < A.length; len++) {
            for (int i = 0; i < A.length - len; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = i; j < i + len; j++) {
                    min = Math.min(min, dp[j][i] + dp[i+len][j+1]);
                }
                dp[i+len][i] = min + sum[i+len][i];
            }
        }
        return dp[A.length-1][0];
    }
    public static void main(String[] args) {
        p476 sol = new p476();
        int[] A = new int[]{4, 1, 1, 4};
        System.out.println(sol.stoneGame(A));
    }
}
