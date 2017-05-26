/**
 * Created by Valued Customer on 5/19/2017.
 *
 * Maximum Product Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example
 For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

 */
public class p191 {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct2(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        int max = nums[0];
        for (int end = 0; end < nums.length; end++) {
            for (int begin = 0; begin < end; begin++) {
                dp[end][begin] = dp[end-1][begin] * nums[end];
                max = Math.max(max, dp[end][begin]);
            }
            max = Math.max(max, dp[end][end]);
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == 0) {
                dp[0][i] = nums[i];
                dp[1][i] = nums[i];
            } else {
                dp[0][i] =Math.max(Math.max(dp[0][i-1] * nums[i], dp[1][i-1] * nums[i]), nums[i]);
                dp[1][i] =Math.min(Math.min(dp[0][i-1] * nums[i], dp[1][i-1] * nums[i]), nums[i]);
            }
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }
        return max;
    }

    public static void main(String[] args) {
        p191 sol = new p191();
        System.out.println(sol.maxProduct(new int[]{1,0,-1,2,3,-5,-2}));
    }
}
