/**
 * Created by Valued Customer on 3/15/2017.
 *
 * Longest Repeating Subsequence
 *
 * Given a string, find length of the longest repeating subsequence such that the two subsequence don’t have same string
 * character at same position, i.e., any ith character in the two subsequences shouldn’t have the same index in the original string.
 *
 * Example
 str = abc, return 0, There is no repeating subsequence

 str = aab, return 1, The two subsequence are a(first) and a(second).
 Note that b cannot be considered as part of subsequence as it would be at same index in both.

 str = aabb, return 2

 */
public class p581 {
    /**
     * @param str a string
     * @return the length of the longest repeating subsequence
     */
    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        if (str == null) return 0;
        if (str.length() <= 1) return str.length();
        int left = 0, right = 1;
        int len = 0;
        while (right < str.length()) {
            String sub = str.substring(left, right);
            String rightStr = str.substring(right, right + 1);
            if (!sub.contains(rightStr)) {
                left = right;
            } else len = Math.max(len, right - left + 1);
            right++;
        }
        len = Math.max(len, right - left);
        return len;
    }

    public static void main(String[] args) {
        p581 sol = new p581();
        System.out.println(sol.longestRepeatingSubsequence("aabb"));
    }
}
