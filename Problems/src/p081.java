import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Valued Customer on 2/12/2017.
 * Data Stream Median
 * Numbers keep coming, return the median of numbers at every time a new number added.
 *
 *Clarification
 What's the definition of Median?
 - Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

 Example
 For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

 For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

 For numbers coming list: [2, 20, 100], return [2, 2, 20].
 */
public class p081 {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        HashHeap smaller = new HashHeap("max");
        HashHeap larger = new HashHeap("min");
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (smaller.size() <= larger.size()) {
                smaller.add(nums[i]);
            } else {
                larger.add(nums[i]);
            }
        }
        return result;
    }
}
