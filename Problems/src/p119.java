/**
 * Created by Valued Customer on 5/23/2017.
 *
 * Edit Distance

 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character

 Example
 Given word1 = "mart" and word2 = "karma", return 3.
 */
public class p119 {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 1; i <= word2.length(); i++) dp[0][i] = Integer.MAX_VALUE;
        for (int i = 1; i <= word1.length(); i++) dp[i][0] = Integer.MAX_VALUE;

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + (word1.charAt(i) == word2.charAt(j)?0:1);
                if (dp[i+1][j+1] < Math.abs(i-j)) dp[i+1][j+1] = Math.abs(i-j);
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public static void main(String[] args) {
        p119 sol = new p119();
        System.out.println(sol.minDistance("ate", "sea"));
    }
}
