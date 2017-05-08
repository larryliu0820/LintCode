/**
 * Created by Valued Customer on 4/18/2017.
 * Maximum Average Subarray
 *
 * Given an array with positive and negative numbers, find the maximum average subarray which length should be greater or equal to given length k.

 Notice

 It's guaranteed that the size of the array is greater or equal to k.

 Example
 Given nums = [1, 12, -5, -6, 50, 3], k = 3

 Return 15.667 // (-6 + 50 + 3) / 3 = 15.667
 */
public class p617 {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        // Write your code here
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < l)
                l = nums[i];
            if (nums[i] > r)
                r = nums[i];
        }


        while (r - l >= 1e-6) {
            double mid = (l + r) / 2.0;

            if (check_valid(nums, mid, k)) {
                l = mid;
            }
            else {
                r = mid;
            }
        }

        return l;
    }

    private boolean check_valid(int nums[], double mid, int k) {
        int n = nums.length;
        double min_pre = 0;
        double[] sum = new double[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if (i >= k ) {
                if (sum[i] - min_pre >= 0) return true;
                min_pre = Math.min(min_pre, sum[i - k + 1]);
            }
        }
        return false;
    }
}
