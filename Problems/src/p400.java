/**
 * Created by Valued Customer on 6/30/2017.
 * Maximum Gap
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Return 0 if the array contains less than 2 elements.

 Notice

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

 Example
 Given [1, 9, 2, 5], the sorted form of it is [1, 2, 5, 9], the maximum gap is between 5 and 9 = 4.
 */
public class p400 {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums == null) return 0;
        int len = nums.length;
        if (len < 2) return 0;
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int width = (max - min) / nums.length + 1;

        int[][] buckets = new int[(max - min) / width + 1][2];
        for (int x : nums) {
            int bucketInd = (x - min) / width;
            if (x < buckets[bucketInd][0] || buckets[bucketInd][1] == 0) buckets[bucketInd][0] = x;
            if (x > buckets[bucketInd][1]) buckets[bucketInd][1] = x;
        }

        int gap = 0;
        int prev = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i][0] == 0 && buckets[i][1] == 0) continue;
            gap = Math.max(gap, buckets[i][0] - buckets[prev][1]);
            prev = i;
        }
        return gap;
    }
}
