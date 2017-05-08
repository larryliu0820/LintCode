/**
 * Created by Valued Customer on 4/25/2017.
 *
 * Copy Books
 *
 * Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

 n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the
 books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

 They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy
 to assign books so that they can finish in shortest time?

 Example
 Given array A = [3,2,4], k = 2.

 Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )


 */
public class p437 {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int[][] dp = new int[pages.length + 1][2];
        int[] sum = new int[pages.length + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= pages.length; i++) {

            sum[i] = sum[i-1] + pages[i-1];
            dp[i][0] = sum[i];
        }
        dp[1][1] = sum[1];
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= pages.length; i++) {
                int min = dp[i][(j+1)%2];
                for (int m = 1; m < i; m ++) {
                    min = Math.min(min, Math.max(dp[m][(j + 1) % 2], sum[i] - sum[m]));
                }
                dp[i][j%2] = min;
            }
        }
        return dp[pages.length][(k-1)%2];
    }

    public static void main(String[] args) {
        p437 sol = new p437();
        System.out.println(sol.copyBooks(new int[]{13,999,1,2,3,9,11}, 2));
    }
}
