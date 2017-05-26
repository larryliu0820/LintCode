/**
 * Created by Valued Customer on 5/25/2017.
 *
 * Longest Common Subsequence
 *
 * Given two strings, find the longest common subsequence (LCS).

 Your code should return the length of LCS.
 Clarification
 What's the definition of Longest Common Subsequence?

 https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 http://baike.baidu.com/view/2020307.htm
 Example
 For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

 For "ABCD" and "EACB", the LCS is "AC", return 2.

 */
public class p077 {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null) return 0;
        if (A.length() == 0 || B.length() == 0) return 0;
        int[][] dp = new int[A.length()+1][B.length()+1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i-1) == B.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                //if (dp[i][j] > Math.abs(i-j)) dp[i][j] = Math.abs(i-j);
            }
        }
        return dp[A.length()][B.length()];
    }
    public static void main(String[] args) {
        p077 sol = new p077();
        System.out.println(sol.longestCommonSubsequence("dccaeedbeb", "bedaacbade"));
    }
}
