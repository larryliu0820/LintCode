import java.util.ArrayList;

/**
 * Created by Valued Customer on 3/2/2017.
 *  Sliding Window Maximum
 *  Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration
 *  from the start of the array, find the maximum number inside the window at each moving.

 Have you met this question in a real interview? Yes
 Example
 For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]

 At first the window is at the start of the array like this

 [|1, 2, 7| ,7, 8] , return the maximum 7;

 then the window move one step forward.

 [1, |2, 7 ,7|, 8], return the maximum 7;

 then the window move one step forward again.

 [1, 2, |7, 7, 8|], return the maximum 8;
 */
public class p362 {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        HashHeap pq = new HashHeap("max");
        if (k > nums.length) k = nums.length;
        for (int i = 0; i < k; i++) pq.add(nums[i]);
        result.add(pq.peek());
        for (int i = 0; i < nums.length - k; i++) {
            pq.delete(nums[i]);
            pq.add(nums[i+k]);
            result.add(pq.peek());
        }
        return result;
    }
}
