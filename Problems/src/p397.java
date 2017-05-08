/**
 * Created by Valued Customer on 5/6/2017.
 * Longest Increasing Continuous Subsequence
 *
 * Give an integer array，find the longest increasing continuous subsequence in this array.

 An increasing continuous subsequence:

 Can be from right to left or from left to right.
 Indices of the integers in the subsequence should be continuous.
 Notice

 O(n) time and O(1) extra space.

 Example
 For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

 For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

 */
public class p397 {

    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        boolean isDescending = false;
        int longestLen = 1;
        int currLen = 1;
        if (A == null || A.length == 0) return 0;
        if (A.length <= 2) return A.length;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                if (isDescending) {
                    currLen += 1;
                } else {
                    currLen = 2;
                    isDescending = true;
                }
            } else {
                if (isDescending) {
                    currLen = 2;
                    isDescending = false;
                } else {
                    currLen += 1;
                }
            }
            longestLen = Math.max(currLen, longestLen);
        }
        return longestLen;
    }
}
