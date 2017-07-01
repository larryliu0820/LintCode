/**
 * Created by Valued Customer on 6/30/2017.
 * Subarray Sum II
 *
 * Given an integer array, find a subarray where the sum of numbers is in a given interval. Your code should return the
 * number of possible answers. (The element in the array should be positive)
 *
 * Example
 Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:

 [0, 0]
 [0, 1]
 [1, 1]
 [2, 2]
 */
public class p404 {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if (A == null) return 0;
        int len = A.length;
        if (len == 0) return 0;
        int[] sum = new int[len+1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i-1] + A[i-1];
        }
        int count = 0;
        for (int phead = 1; phead <= len; phead++) {
            for (int ptail = 1; ptail <= phead; ptail++) {
                int currSum = sum[phead] - sum[ptail] + A[ptail-1];
                if (currSum <= end && currSum >= start) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        p404 sol = new p404();
        sol.subarraySumII(new int[]{1,2,3,4}, 1, 3);
    }
}
