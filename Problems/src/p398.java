/**
 * Created by Valued Customer on 5/21/2017.
 *
 * Longest Increasing Continuous subsequence II
 *
 * Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in
 * this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column
 * and go up/down/right/left any direction).
 *
 * [
 [1 ,2 ,3 ,4 ,5],
 [16,17,24,23,6],
 [15,18,25,22,7],
 [14,19,20,21,8],
 [13,12,11,10,9]
 ]
 */
public class p398 {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    int[][] dp;
    boolean[][] flag;

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0 || A[0].length == 0) return 0;
        int m = A.length;
        int n = A[0].length;
        dp = new int[m][n];
        dp[0][0] = 1;
        flag = new boolean[m][n];
        flag[0][0] = true;

        int max = 1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                max = Math.max(max, search(A, row, col));
            }
        }
        return max;

    }

    private int search(int[][] A, int row, int col) {
        if (flag[row][col]) return dp[row][col];
        int ans = dp[row][col];
        for (int i = 0; i < 4; i++) {
            int r = row + dx[i];
            int c = col + dy[i];
            if (r < A.length && r >= 0 && c < A[0].length && c >= 0 && A[r][c] < A[row][col])
                ans = Math.max(ans, search(A, r, c));
        }
        dp[row][col] = ans + 1;
        flag[row][col] = true;
        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] A = new int[][] {
                {1, 2, 3, 4, 5},
                {16,17,24,23,6},
                {15,18,25,22,7},
                {14,19,20,21,8},
                {13,12,11,10,9}
        };
        p398 sol = new p398();
        System.out.println(sol.longestIncreasingContinuousSubsequenceII(A));
    }
}
