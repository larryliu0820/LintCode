/**
 * Created by Valued Customer on 5/10/2017.
 *
 * Longest Palindromic Substring
 *
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 *
 * Example
 Given the string = "abcdzdcab", return "cdzdc".

 O(n2) time is acceptable. Can you do it in O(n) time.
 */
public class p200 {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        int i, j;
        int max = 1;
        int L[][] = new int[s.length()][s.length()];

        for (i = 0; i < s.length(); i++) {
            L[i][i] = 1;
        }
        String longest = s.substring(0,1);
        for (int subLen = 2; subLen <= s.length(); subLen++) {
            for (i = 0; i < s.length() - subLen + 1; i++) {
                j = i + subLen - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1 || L[i + 1][j - 1] == subLen - 2) {
                        L[i][j] = subLen;
                        longest = s.substring(i, j + 1);
                        max = Math.max(max, subLen);
                    }
                } else
                    L[i][j] = 1;
            }
        }
        System.out.println(max);
        return longest;
    }

    public static void main(String[] args) {
        p200 sol = new p200();
        System.out.println(sol.longestPalindrome("abcdzdcab"));
    }
}
