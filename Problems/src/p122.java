import java.util.Stack;

/**
 * Created by Valued Customer on 4/18/2017.
 *
 * Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 Example
 Given height = [2,1,5,6,2,3],
 return 10.

 */
public class p122 {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        int answer = 0;
        if (height == null || height.length == 0) return answer;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()]> height[i]) {
                int pos = stack.pop();
                answer = Math.max(answer, height[pos] * (stack.isEmpty()?i:i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pos = stack.pop();
            answer = Math.max(answer, height[pos] * (stack.isEmpty()?height.length:height.length-stack.peek()-1));
        }
        return answer;
    }
}
