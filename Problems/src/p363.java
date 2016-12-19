import java.util.PriorityQueue;

/**
 * Created by larryliu on 12/19/16.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Example
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class p363 {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        int count = 0;
        if (heights == null || heights.length == 0) return count;
        int start = 0, end = heights.length - 1;
        while (start < end) {
            if (heights[start] < heights[end]) {
                int smaller = heights[start];
                while (start < end && heights[start] <= smaller) {
                    count += smaller - heights[start++];
                }
            } else {
                int smaller = heights[end];
                while (start < end && heights[end] <= smaller) {
                    count += smaller - heights[end--];
                }
            }
        }
        return count;
    }
}
