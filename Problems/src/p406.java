/**
 * Created by larryliu on 3/8/17.
 * Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the
 * sum ≥ s. If there isn't one, return -1 instead.
 *
 * Example
 Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.


 */
public class p406 {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) return -1;
        int i = 0, j = 0;
        int currSum = nums[0];
        int minSize = nums.length + 1;
        while (i <= j && j < nums.length) {
            if (currSum < s) {
                if (j == nums.length - 1) break;
                currSum += nums[++j];
            } else {
                System.out.println(String.format("i = %d, j = %d", i, j ));
                minSize = Math.min(minSize, j-i+1);
                if (j == i) break;
                currSum -= nums[i++];
            }
        }
        if (currSum >= s) minSize = Math.min(minSize, j-i+1);
        return minSize == nums.length + 1?-1:minSize;
    }
    public static void main(String[] args) {
        p406 sol = new p406();
        int[] nums = new int[] {2, 3, 1, 2, 4, 3};
        System.out.println(sol.minimumSize(nums, 7));
    }
}
