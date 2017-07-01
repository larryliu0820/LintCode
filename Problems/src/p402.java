import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Valued Customer on 6/27/2017.
 * Continuous Subarray Sum

 Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the
 index of the first number and the index of the last number. (If their are duplicate answer, return anyone)

 Example
 Give [-3, 1, 3, -3, 4], return [1,4].
 */
public class p402 {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) return result;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int begin = 0, end = 0;
        int s = 0;
        for (int i = 0;i < A.length; i++) {
            sum += A[i];
            if (maxSum < sum) {
                maxSum = sum;
                begin = s;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                s = i+1;
            }
        }
        result.add(begin);
        result.add(end);
        return result;
    }
}
