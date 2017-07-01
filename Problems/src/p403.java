import java.util.ArrayList;

/**
 * Created by Valued Customer on 6/28/2017.
 * Continuous Subarray Sum II
 *
 * Given an circular integer array (the next element of the last element is the first element), find a continuous
 * subarray in it, where the sum of numbers is the biggest. Your code should return the index of the first number and
 * the index of the last number.

 If duplicate answers exist, return any of them.

 Example
 Give [3, 1, -100, -3, 4], return [4,1].
 */
public class p403 {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length == 0) return result;
        int[][] sub = subSum(A);
        int first = 0, last = 0;
        if (sub[0][3] - sub[1][2] > sub[0][2]) {
            last = sub[1][0] - 1;
            first = sub[1][1] + 1;
        } else {
            first = sub[0][0];
            last = sub[0][1];
        }
        // corner case(all elements are negtive)
        if (last == -1 && first == A.length) {
            first = sub[0][0];
            last = sub[0][1];
        }

        result.add(first);
        result.add(last);
        return result;
    }

    private int[][] subSum(int[] A) {
        int[][] result = new int[2][];
        // find the max/min subarray sum from [0...A.length]
        int sum = 0, minSum = 0, maxSub = Integer.MIN_VALUE;
        int maxSum = 0, minSub = Integer.MAX_VALUE;
        int firstMax = 0, lastMax = 0;
        int firstMin = 0, lastMin = 0;
        int first2 = 0; // candidate for first
        int first1 = 0; // candidate for first
        for (int i = 0; i < A.length; i++) {
            if (minSum > sum) {
                minSum = sum;
                first2 = i;
            }
            if (maxSum < sum) {
                maxSum = sum;
                first1 = i;
            }
            sum += A[i];
            if (sum - minSum > maxSub) {
                maxSub = sum - minSum;
                lastMax = i;
                // update first if valid
                if (first2 <= lastMax) firstMax = first2;
            }
            if (sum - maxSum < minSub) {
                minSub = sum - maxSum;
                lastMin = i;
                if (first1 <= lastMin) firstMin = first1;
            }
        }
        result[0] = new int[]{firstMax, lastMax, maxSub, sum};
        result[1] = new int[]{firstMin, lastMin, minSub, sum};
        return result;
    }
}
