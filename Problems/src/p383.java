/**
 * Created by larryliu on 3/9/17.
 *
 *  Container With Most Water
 *  Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
 *  are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 *  forms a container, such that the container contains the most water.

 Notice

 You may not slant the container.

 Example
 Given [1,3,2], the max area of the container is 2.

 */
public class p383 {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) return 0;
        int begin = 0, end = heights.length - 1;
        int level = Math.min(heights[begin], heights[end]);
        int area = (end - begin) * level;
        int sum = 0;
        while (begin <= end) {
            if(Math.min(heights[begin], heights[end]) > level) {
                int newLevel = Math.min(heights[begin], heights[end]);
                area += (newLevel - level) * (end - begin + 1);
                level = newLevel;
            }
            if(heights[begin] <= heights[end]) {
                sum += heights[begin++];
            }else{
                sum += heights[end--];
            }
        }
        return area - sum;
    }
}
