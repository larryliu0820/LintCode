import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Valued Customer on 1/6/2017.
 * Sliding Window Median
 * Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array,
 * find the median of the element inside the window at each moving. (If there are even numbers in the array,
 * return the N/2-th number after sorting the element in the window. )
 *
 * Example
 For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

 At first the window is at the start of the array like this

 [ | 1,2,7 | ,8,5] , return the median 2;

 then the window move one step forward.

 [1, | 2,7,8 | ,5], return the median 7;

 then the window move one step forward again.

 [1,2, | 7,8,5 | ], return the median 7;
 */
public class p360 {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        HashHeap smallerPq = new HashHeap("max");
        HashHeap largerPq = new HashHeap("min");
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        for (int i = 0; i < k; i++) {
            largerPq.add(nums[i]);
        }
        for (int i = 0; i < (k+1) / 2; i++) {
            smallerPq.add(largerPq.poll());
        }

        int currMedian = smallerPq.peek();
        result.add(currMedian);

        for (int i = 0; i < nums.length - k; i++) {

            if (i == 1)
                System.out.println(i);
            int oldNum = nums[i];
            int currNum = nums[i+k];
            if (smallerPq.heap.contains(oldNum)) {
                smallerPq.delete(oldNum);
                if (currNum > currMedian) {
                    largerPq.add(currNum);
                    smallerPq.add(largerPq.poll());
                } else {
                    smallerPq.add(currNum);
                }
            } else {
                if (!largerPq.heap.contains(oldNum))
                    System.out.println(oldNum);
                largerPq.delete(oldNum);
                if (currNum <= currMedian) {
                    smallerPq.add(currNum);
                    largerPq.add(smallerPq.poll());
                } else {
                    largerPq.add(currNum);
                }
            }

            result.add(smallerPq.peek());
            currMedian = smallerPq.peek();
        }
        return result;
    }


    public static void main(String[] args) {
        p360 sol = new p360();
        String filename = "Problems/src/15.in";
        int[] data = null;
        int num = 0;
        try {
            FileReader fileReader = new FileReader(filename);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String content = bufferedReader.readLine();
            String[] list = content.split(",");
            num = Integer.parseInt(list[list.length-1]);
            data = new int[list.length - 1];
            for (int i = 0; i < list.length - 1; i++) {
                data[i] = Integer.parseInt(list[i]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("no such file");
        } catch (IOException ex) {
            System.out.println("Error");
        }
        System.out.println(sol.medianSlidingWindow(data, num));
    }
}
